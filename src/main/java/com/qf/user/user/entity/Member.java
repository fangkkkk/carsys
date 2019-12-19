package com.qf.user.user.entity;

import lombok.Data;

@Data
public class Member {
    private Long id;
    private String username;//用户名  手机号
    private String password;//密码 密文
    private Byte source; //状态
}