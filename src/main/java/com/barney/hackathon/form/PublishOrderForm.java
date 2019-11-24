package com.barney.hackathon.form;

import lombok.Data;

@Data
public class PublishOrderForm {
    private String token;
    private String title;
    private long deadline;
    private long lasting;
    private int gift;
    private String type;
    private int money;
    private String content;
}
