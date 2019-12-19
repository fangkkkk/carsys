package com.qf.user.user.dao;

import com.qf.user.user.entity.MemberProfileLog;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberProfileLogMapper {
    int insert(MemberProfileLog record);
}