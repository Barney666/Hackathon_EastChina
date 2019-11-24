package com.barney.hackathon.form;

import lombok.Data;

@Data
public class PublishInfoForm {
    private String token;
    private String title;
    private String content;
}
