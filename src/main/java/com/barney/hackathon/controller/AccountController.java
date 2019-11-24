package com.barney.hackathon.controller;

import com.barney.hackathon.HackathonEastChinaApplication;
import com.barney.hackathon.constant.SimpleResponse;
import com.barney.hackathon.dao.AccountDao;
import com.barney.hackathon.entity.Account;
import com.barney.hackathon.form.ChangePasswordForm;
import com.barney.hackathon.form.LoginForm;
import com.barney.hackathon.form.TokenForm;
import com.barney.hackathon.form.UpdateForm;
import com.barney.hackathon.vo.ChangePasswordVO;
import com.barney.hackathon.vo.UpdateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountDao accountDao;

    @RequestMapping("/register")
    public SimpleResponse register(@RequestBody Account account){
        System.out.println("一个用户进行注册操作");
        if(accountDao.findByUsername(account.getUsername())==null){
            accountDao.addAccount(account);
            System.out.println("成功创建账户"+account);
            return new SimpleResponse(0);
        }
        System.out.println("用户名被占用");
        return new SimpleResponse(1);
    }

    @RequestMapping("/login")
    public SimpleResponse login(@RequestBody LoginForm loginForm){
        System.out.println("一个用户进行登陆操作");
        Account tempAccount=accountDao.findByNameAndPassword(loginForm.getUsername(),loginForm.getPassword());
        if(tempAccount!=null){
            System.out.println(tempAccount+"成功登陆");
            Map backData=new HashMap();
            String string= UUID.randomUUID().toString().replace("-","");  //32位随机String
            System.out.println(string);
            HackathonEastChinaApplication.tokenMap.put(string,tempAccount);
            backData.put("token",string);
            backData.put("name",tempAccount.getName());
            backData.put("id",tempAccount.getId());
            return new SimpleResponse(0,backData);
        }
        return new SimpleResponse(1);
    }

    @RequestMapping("/password")
    public SimpleResponse changePassword(@RequestBody ChangePasswordForm changePasswordForm){
        System.out.println("一个用户进行修改密码操作");
        String token=changePasswordForm.getToken();
        String oldpassword=changePasswordForm.getOldpassword();
        String newpassword=changePasswordForm.getNewpassword();

        String username=HackathonEastChinaApplication.findAccountByToken(token).getUsername();
        if(accountDao.findByNameAndPassword(username,oldpassword)!=null){
            accountDao.changePassword(new ChangePasswordVO(username,newpassword));
            System.out.println("成功修改密码为"+newpassword);
            return new SimpleResponse(0);
        }
        else {
            System.out.println("用户名不正确或密码错误");
            return new SimpleResponse(1);  //有错误
        }
    }

    @RequestMapping("/update")
    public SimpleResponse update(@RequestBody UpdateForm updateForm){
        try {
            System.out.println("一个用户进行更新信息操作");
            String token=updateForm.getToken();
            String name=updateForm.getName();
            String phone=updateForm.getPhone();
            int grade=updateForm.getGrade();
            String major=updateForm.getMajor();
            String username=HackathonEastChinaApplication.findAccountByToken(token).getUsername();

            UpdateVO updateVO=new UpdateVO(username,name,phone,grade,major);
            accountDao.changefeature(updateVO);
            return new SimpleResponse(0);
        }catch (Exception e){
            return new SimpleResponse(1,e);
        }
    }

    @RequestMapping("/me")
    public SimpleResponse me(@RequestBody TokenForm tokenForm){
        try {
            String token=tokenForm.getToken();
            Account account=HackathonEastChinaApplication.findAccountByToken(token);
            return new SimpleResponse(0,account);   //直接给对象是可以的 data里是json格式
        }catch (Exception e){
            return new SimpleResponse(1,e);
        }
    }

    @RequestMapping("/logout")
    public SimpleResponse logout(@RequestBody TokenForm tokenForm){
        try {
            String token=tokenForm.getToken();
            String username=HackathonEastChinaApplication.findAccountByToken(token).getUsername();
            Account account=accountDao.findByUsername(username);
            System.out.println(account+"已下线");
            return new SimpleResponse(0,account);
        }catch (Exception e){
            return new SimpleResponse(1,e);
        }
    }



}

