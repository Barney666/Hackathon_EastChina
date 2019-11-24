package com.barney.hackathon.form;

import lombok.Data;

@Data
public class ChangePasswordForm {
    private String token;
    private String oldpassword;
    private String newpassword;
}
