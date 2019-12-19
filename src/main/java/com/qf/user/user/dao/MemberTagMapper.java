package com.qf.user.user.dao;

import com.qf.user.user.entity.MemberTag;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberTagMapper {
    int insert(MemberTag record);
}