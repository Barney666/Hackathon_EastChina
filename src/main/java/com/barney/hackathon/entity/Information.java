package com.barney.hackathon.entity;

import lombok.Data;

@Data
public class Information {
    private int id;      //信息编号
    private String title;   //信息标题
    private String content; //信息内容
    private String name;    //发布者信息
    private long createtime;//发布时间
    private int uid;        //发布者id
}
