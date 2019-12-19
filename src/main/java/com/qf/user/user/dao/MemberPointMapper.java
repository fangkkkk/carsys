package com.qf.user.user.dao;

import com.qf.user.user.entity.MemberPoint;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberPointMapper {
    int insert(MemberPoint record);
}