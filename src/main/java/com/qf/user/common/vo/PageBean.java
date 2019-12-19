package com.qf.user.common.vo;

import lombok.Data;

import java.util.List;

/**
 * @program: CarSys
 * @description:
 * @author: Feri
 * @create: 2019-12-10 14:43
 */
@Data
public class PageBean<T> {
    private int page;
    private int total;
    private int size;
    private long totalPage;
    private List<T> data;
}
