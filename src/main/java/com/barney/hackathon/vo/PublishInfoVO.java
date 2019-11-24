package com.barney.hackathon.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
* VO本来应该是返回给前端的封装 但这里似乎是和数据库交互了
*/

@Data
@AllArgsConstructor
public class PublishInfoVO {
    private String title;
    private String name;
    private String content;
    private long createtime;
    private int uid;
}
