package com.qf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.qf.user.user.dao,com.qf.user.oss.dao")
@SpringBootApplication
public class SyscarApplication {

    public static void main(String[] args) {
        SpringApplication.run(SyscarApplication.class, args);
    }

}
