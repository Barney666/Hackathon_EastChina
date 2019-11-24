package com.barney.hackathon.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AcceptVO {
    private int id;
    private String name2;
    private String phone2;
    private int score2;
    private long accepttime;
}
