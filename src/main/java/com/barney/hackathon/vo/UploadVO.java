package com.barney.hackathon.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UploadVO {
    private String name;    //资源名称
    private int uid;        //资源上传者id
    private String uname;   //资源上传者姓名
    private long updatetime;    //资源更新时间
    private String type;        //资源类型
    private String url;         //资源的URL
    private String content;     //资源说明
}
