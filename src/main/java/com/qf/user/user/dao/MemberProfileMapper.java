package com.qf.user.user.dao;

import com.qf.user.user.entity.MemberProfile;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberProfileMapper {
    int insert(MemberProfile record);

}