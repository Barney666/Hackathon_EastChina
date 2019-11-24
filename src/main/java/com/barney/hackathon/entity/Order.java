package com.barney.hackathon.entity;

import lombok.Data;

@Data
public class Order {
    private int id;  //信息标号
    private String title;   //信息标题
    private String name;    //发布人姓名
    private String phone;   //发布人手机
    private int score;   //发布人信誉评分
    private String name2;   //接取人姓名
    private String phone2;  //接取人手机
    private int score2;  //接取人信誉评分
    private long deadline;    //截止日期
    private long lasting;     //预计所需时间
    private int gift;        //赏金
    private String type;        //跑腿类型
    private int money;       //需要花费的金额
    private long createtime;        //发布时间
    private String content;     //具体内容
    private int status;      //信息状态
    /*
    status 信息状态
    0 等待接单
    1 已接单，正在进行中
    2 已完成
    3 已取消
    */
    private long accepttime; //接取时间
    private long finishtime; //完成时间
    private int breakfaith;  //如果有失信 他的失信类型
    /*
    1.发出者已接取却取消
    2.接受者接取却取消
    3.订单未完成
    4.订单完成但已经过ddl
    */



}
