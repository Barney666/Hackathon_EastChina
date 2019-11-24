package com.barney.hackathon.form;
/*
*   接受前端数据的封装
*/
import lombok.Data;

@Data
public class UpdateForm {
    private String token;
    private String name;
    private String phone;
    private int grade;
    private String major;
}
