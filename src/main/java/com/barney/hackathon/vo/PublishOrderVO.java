package com.barney.hackathon.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PublishOrderVO {
//    private int id;  //信息标号
    private String title;   //信 息标题
    private String name;    //发布人姓名
    private String phone;   //发布人手机
    private int score;   //发布人信誉评分
//    private String name2;   //接取人姓名
//    private String phone2;  //接取人手机
//    private int score2;  //接取人信誉评分
    private long deadline;    //截止日期
    private long lasting;     //预计所需时间
    private int gift;        //赏金
    private String type;        //跑腿类型
    private int money;       //需要花费的金额
    private long createtime;        //发布时间
    private String content;     //具体内容
    private int status;      //信息状态
//    private long accepttime; //接取时间
//    private long finishtime; //完成时间
//    private int breakfaith;  //如果有失信 他的失信类型
    //TODO 订单被失信怎么扣 人 的分数
}

