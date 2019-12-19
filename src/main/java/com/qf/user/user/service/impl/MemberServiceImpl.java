package com.qf.user.user.service.impl;

import com.qf.user.common.result.ResultCode;
import com.qf.user.common.vo.PageBean;
import com.qf.user.common.vo.R;
import com.qf.user.config.RedisKeyConfig;
import com.qf.user.dto.MemberQueryDto;
import com.qf.user.user.dao.MemberMapper;
import com.qf.user.user.entity.Member;
import com.qf.user.user.service.MemberService;
import com.qf.user.util.JedisUtil;
import com.qf.user.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: CarSys
 * @description:
 * @author: Feri
 * @create: 2019-12-10 11:23
 */
@Service
public class MemberServiceImpl implements MemberService {
    /**
     * 警告
     */
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private JedisUtil jedisUtil;
    @Override
    public R queryByMsg(String msg) {
        Member member=memberMapper.selectByMsg(msg);
        if(member==null){
            //名称不存在  可用
            return R.Ok();
        }else {
            return R.fail();
        }
    }

    @Override
    public R register(Member member) {
        //1、校验是否存在
        if(queryByMsg(member.getUsername()).getCode()== ResultCode.OK.getVal()){
            //2、不存在 再新增
            int c=memberMapper.insert(member);
            if(c>0){
                return R.Ok();
            }else {
                return R.fail();
            }
        }else {
            return R.fail("用户名已经被注册");
        }
    }

    @Override
    public R login(String name,String pass) {
        //1、根据用户名查询用户信息
        Member m=memberMapper.selectByMsg(name);
        //2、校验用户是否存在
        if(m!=null){
            //3、校验密码是否正确
            if(m.getPassword().equals(pass)){
                //4、成功 生成令牌 存储为当前会员的id信息
                String token= JwtUtil.createJWT(m.getId()+"");
                //令牌 Token 有效期  Redis  有效期
                jedisUtil.addStr(RedisKeyConfig.TOKEN_KEY +name,token,RedisKeyConfig.TOEKN_TIME);
                return R.Ok(token);
            }
        }
        return R.fail("用户名或密码错误");
    }

    @Override
    public R search(MemberQueryDto memberQueryDto) {
        //查询所有的数据
        List<Member> memberList=memberMapper.selectPage(memberQueryDto.getPage(),memberQueryDto.getSize());
        //实例化分页类
        PageBean<Member> pageBean=new PageBean<>();
        pageBean.setData(memberList);
        pageBean.setPage(memberQueryDto.getPage());
        pageBean.setSize(memberQueryDto.getSize());
        pageBean.setTotalPage(memberMapper.selectCount());
        //计算总页数
        pageBean.setTotalPage(pageBean.getTotal()%memberQueryDto.getSize()==0?pageBean.getTotal()/pageBean.getSize()
                :pageBean.getTotal()/pageBean.getSize()+1);
        return R.Ok(pageBean);
    }
}
