package com.barney.hackathon.controller;

import com.barney.hackathon.HackathonEastChinaApplication;
import com.barney.hackathon.constant.SimpleResponse;
import com.barney.hackathon.dao.InformationDao;
import com.barney.hackathon.entity.Account;
import com.barney.hackathon.entity.Information;
import com.barney.hackathon.form.PublishInfoForm;
import com.barney.hackathon.form.CancelForm;
import com.barney.hackathon.vo.IdVO;
import com.barney.hackathon.vo.PublishInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/info")
public class InfoController {

    @Autowired
    InformationDao informationDao;

    @RequestMapping("/publish")
    public SimpleResponse publish(@RequestBody PublishInfoForm publishInfoForm){
        try {
            String token= publishInfoForm.getToken();
            Account tempAccount=HackathonEastChinaApplication.findAccountByToken(token);
            String name=tempAccount.getName();
            int uid=tempAccount.getId();
            long createtime=System.currentTimeMillis();   //unix时间戳
            PublishInfoVO publishInfoVO =new PublishInfoVO(publishInfoForm.getTitle(),name, publishInfoForm.getContent(),createtime,uid);
            informationDao.publish(publishInfoVO);
            System.out.println("一个用户发布信息");
            int id=informationDao.findByTitle(publishInfoForm.getTitle()).getId();
            return new SimpleResponse(0,new IdVO(id));
        }catch (Exception e){
            return new SimpleResponse(1,e);
        }
    }

    @RequestMapping("/cancelInfo")
    public SimpleResponse cancelInfo(@RequestBody CancelForm cancelForm){
        try{
            String token= cancelForm.getToken();
            String name=HackathonEastChinaApplication.findAccountByToken(token).getName();

            Information tempInformation=informationDao.findById(cancelForm.getId());
            if(tempInformation!=null){
                String uname=tempInformation.getName();
                if(name.equals(uname)){
                    System.out.println("一个用户删除已发布信息");
                    informationDao.deleteById(cancelForm.getId());
                    return new SimpleResponse(0);
                }
            }
            return new SimpleResponse(1);
        }catch (Exception e){
            return new SimpleResponse(1,e);
        }


    }

    @RequestMapping("/getInfoList")
    public SimpleResponse getInfoList(){
        try {
            System.out.println("获取信息列表");
            Map map=new HashMap<String, List>();
            map.put("infos",informationDao.findAll());
            return new SimpleResponse(0,map);
        }catch (Exception e){
            return new SimpleResponse(1,e);
        }
    }

}
