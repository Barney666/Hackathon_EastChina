package com.barney.hackathon.dao;

import com.barney.hackathon.entity.Information;
import com.barney.hackathon.vo.PublishInfoVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface InformationDao {

    @Insert("insert into information(title,name,content,createtime,uid) values(#{title},#{name},#{content},#{createtime},#{uid})")
    void publish(PublishInfoVO publishInfoVO);

    @Select("select * from information where title=#{title}")
    Information findByTitle(String tile);

    @Select("select * from information where id=#{id}")
    Information findById(int id);

    @Select("select * from information")
    List<Information> findAll();

    @Delete("delete from information where id=#{id}")
    void deleteById(int id);
}
