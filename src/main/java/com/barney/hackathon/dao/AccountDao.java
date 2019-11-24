package com.barney.hackathon.dao;

import com.barney.hackathon.entity.Account;
import com.barney.hackathon.vo.ChangePasswordVO;
import com.barney.hackathon.vo.UpdateVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AccountDao {

    @Select("select * from account where username=#{username}")
    Account findByUsername(String username);  //看是否存在这个用户名

    @Select("select * from account where name=#{name}")
    Account findByName(String name);  //看是否存在这个名

    @Select("select * from account where username=#{username} and password=#{password}")
    Account findByNameAndPassword(String username,String password);   //根据用户名和密码查询

    @Insert("insert into account(name,phone,grade,major,password,username) values(#{name},#{phone},#{grade},#{major},#{password},#{username})")
    void addAccount(Account account);   //增加一个用户

    @Update("update account set password=#{password} where username=#{username}")
    void changePassword(ChangePasswordVO changePasswordVO);   //修改密码

    @Update("update account set name=#{name},phone=#{phone},grade=#{grade},major=#{major} where username=#{username}")
    void changefeature(UpdateVO updateVO);    //更新信息


}
