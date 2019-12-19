package com.qf.user.sms.service;


import com.qf.user.common.vo.R;
import com.qf.user.dto.PhoneCodeDto;

public interface SmsService {

    R sendSmsCode(String phone);
    R checkSmsCode(PhoneCodeDto codeDto);
}
