package com.qf.user.dto;

import lombok.Data;

/**
 * @program: CarSys
 * @description:
 * @author: Feri
 * @create: 2019-12-10 14:41
 */
@Data
public class MemberQueryDto {
    private int page;
    private int size;
    private String name;
    private int sex;
}