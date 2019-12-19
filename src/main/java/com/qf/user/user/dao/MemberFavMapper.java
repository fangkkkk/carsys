package com.qf.user.user.dao;

import com.qf.user.user.entity.MemberFav;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberFavMapper {
    int insert(MemberFav record);
}