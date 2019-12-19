package com.qf.user.user.dao;

import com.qf.user.user.entity.MemberCar;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberCarMapper {
    int insert(MemberCar record);
}