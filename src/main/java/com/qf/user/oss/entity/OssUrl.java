package com.qf.user.oss.entity;

import lombok.Data;

import java.util.Date;

@Data
public class OssUrl {
    private Integer id;
    private String objname;
    private String url;
    private Date ctime;
    private Date endtime;
}

