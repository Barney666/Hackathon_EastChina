package com.barney.hackathon.form;

import lombok.Data;

@Data
public class UploadForm {
    private String token;
    private String name;
    private String type;
    private String url;
    private String content;
}
