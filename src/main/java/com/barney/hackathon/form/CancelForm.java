package com.barney.hackathon.form;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CancelForm {
    private String token;
    private int id;
}
