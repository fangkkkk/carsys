package com.qf.user.test;

import com.qf.user.util.JwtUtil;
import org.junit.Test;

/**
 * @program: CarSys
 * @description:
 * @author: Feri
 * @create: 2019-12-11 14:48
 */
public class Jwt_Test {
    @Test
    public void t1(){
    String m="admin";
    String t= JwtUtil.createJWT(1+"",30,m);
        System.out.println(t);
        //解析
        System.out.println(JwtUtil.parseJWT(t));
    }
}
