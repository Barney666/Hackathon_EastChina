package com.barney.hackathon.entity;

import lombok.Data;

@Data
public class Account {
    private int id;        //数据库唯一标示
    private String username;   //登录名
    private String name;        //实名
    private String phone;
    private int grade;         //年级
    private String major;
    private String password;
    private int score;       //信誉评分
    private double balalance;   //用户余额
}
