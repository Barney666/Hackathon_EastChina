package com.barney.hackathon.vo;
/**
 *  传回数据的封装
 */
import lombok.AllArgsConstructor;
import lombok.Data;

@Data    //get和set方法
@AllArgsConstructor   //有参构造函数
public class UpdateVO {
    private String username;
    private String name;
    private String phone;
    private int grade;
    private String major;
}
