package com.qf.user.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @program: CarSys
 * @description:
 * @author: Feri
 * @create: 2019-12-12 15:08
 */
public class DateUtil {
    //获取指定年 的今天
    public static Date addYear(int y){
        //日历 类 完成实例化
        Calendar calendar=Calendar.getInstance();
        //计算日期
        calendar.add(Calendar.YEAR,y);
        return calendar.getTime();
    }
}