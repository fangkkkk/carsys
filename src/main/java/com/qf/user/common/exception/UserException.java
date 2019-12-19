package com.qf.user.common.exception;

/**
 * @program: CarSys
 * @description: 会员异常 自定义异常
 * @author: Feri
 * @create: 2019-12-10 09:48
 */
public class UserException extends Exception {
    public UserException(){
        super();
    }
    public UserException(String msg){
        super(msg);
    }
}
