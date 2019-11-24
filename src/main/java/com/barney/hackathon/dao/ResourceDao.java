package com.barney.hackathon.dao;

import com.barney.hackathon.entity.Resource;
import com.barney.hackathon.vo.UploadVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ResourceDao {

    @Insert("insert into resource(name,uid,uname,updatetime,type,url,content) values(#{name},#{uid},#{uname},#{updatetime},#{type},#{url},#{content})")
    void upload(UploadVO uploadVO);

    @Select("select * from resource where name=#{name}")
    Resource findByName(String name);

    @Select("select * from resource where id=#{id}")
    Resource findById(int id);

    @Delete("delete from resource where id=#{id}")
    void deleteById(int id);

    @Select("select * from resource")
    List<Resource> findAll();
}
