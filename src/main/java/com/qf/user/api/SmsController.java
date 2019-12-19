package com.qf.user.api;

import com.qf.user.common.vo.R;
import com.qf.user.dto.PhoneCodeDto;
import com.qf.user.sms.service.SmsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * @program: CarSys
 * @description: 短信 发送和验证
 * @author: Feri
 * @create: 2019-12-11 11:41
 */
@Api(value = "短信验证码",tags = "短信验证码")
@RestController
public class SmsController {

    @Autowired
    private SmsService smsService;
    //发送短信验证码
    @ApiOperation(value = "发送短信验证码",notes = "发送短信验证码")
    @GetMapping("/api/sms/sendcode.do")
    public R sendSmsCode(String phone)
    {
        return smsService.sendSmsCode(phone);
    }
    //校验短信验证码
    @ApiOperation(value = "校验短信验证码",notes = "校验短信验证码")
    @PostMapping("/api/sms/checksmscode.do")
    public R checkSmsCode(@RequestBody PhoneCodeDto phoneCodeDto){
        return smsService.checkSmsCode(phoneCodeDto);
    }
}
