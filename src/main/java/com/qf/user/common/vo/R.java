package com.qf.user.common.vo;

import com.qf.user.common.result.ResultCode;
import lombok.Data;

/**
 * @program: CarSys
 * @description:
 * @author: Feri
 * @create: 2019-12-10 11:03
 */
@Data
public class R {
    private int code;//结果码
    private String msg;//字符串
    private Object data;//携带数据

    public static R setR(int code,String msg,Object data){
        R r=new R();
        r.setCode(code);
        r.setData(data);
        r.setMsg(msg);
        return r;
    }
    public static R Ok(Object data){
        return setR(ResultCode.OK.getVal(),"OK",data);
    }
    public static R Ok(){
        return setR(ResultCode.OK.getVal(),"OK",null);
    }
    public static R fail(){
        return setR(ResultCode.ERROR.getVal(),"Error",null);
    }
    public static R fail(String msg){
        return setR(ResultCode.ERROR.getVal(),msg,null);
    }

}
