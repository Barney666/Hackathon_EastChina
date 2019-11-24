package com.barney.hackathon.controller;

import com.barney.hackathon.HackathonEastChinaApplication;
import com.barney.hackathon.constant.SimpleResponse;
import com.barney.hackathon.dao.ResourceDao;
import com.barney.hackathon.entity.Account;
import com.barney.hackathon.entity.Resource;
import com.barney.hackathon.form.CancelForm;
import com.barney.hackathon.form.UploadForm;
import com.barney.hackathon.vo.IdVO;
import com.barney.hackathon.vo.UploadVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    ResourceDao resourceDao;

    @RequestMapping("/upload")
    public SimpleResponse upload(@RequestBody UploadForm uploadForm){
        try {
            String token=uploadForm.getToken();
            Account tempAccount= HackathonEastChinaApplication.findAccountByToken(token);

            String uname=tempAccount.getName();
            int uid=tempAccount.getId();
            long updatetime=System.currentTimeMillis();   //unix时间戳
            UploadVO uploadVO=new UploadVO(uploadForm.getName(),uid,uname,updatetime,uploadForm.getType(),uploadForm.getUrl(),uploadForm.getContent());
            resourceDao.upload(uploadVO);
            int id=resourceDao.findByName(uploadForm.getName()).getId();
            return new SimpleResponse(0,new IdVO(id));
        }catch (Exception e){
            return new SimpleResponse(1,e);
        }
    }

    @RequestMapping("/remove")
    public SimpleResponse remove(@RequestBody CancelForm cancelForm){   //这里所谓的RemoveForm和CancelForm一样 就没再写一个
        try {
            String token= cancelForm.getToken();
            String name=HackathonEastChinaApplication.findAccountByToken(token).getName();
            Resource tempResource=resourceDao.findById(cancelForm.getId());
            System.out.println(tempResource);
            if(tempResource!=null){
                String uname=tempResource.getName();
                if(name.equals(uname)){
                    System.out.println("一个用户删除已发布资源");
                    resourceDao.deleteById(cancelForm.getId());
                    return new SimpleResponse(0);
                }
            }
            return new SimpleResponse(1);
        }catch (Exception e){
            return new SimpleResponse(1,e);
        }
    }

    @RequestMapping("/getResourceList")
    public SimpleResponse getResourceList(){
        try {
            System.out.println("获取资源列表");
            Map map=new HashMap<String, List>();
            map.put("resources",resourceDao.findAll());
            return new SimpleResponse(0,map);
        }catch (Exception e){
            return new SimpleResponse(1,e);
        }
    }
}
