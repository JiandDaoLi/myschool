package com.school.service.impl;

import com.school.entity.TUser;
import com.school.entity.TUserExample;
import com.school.mapper.TUserMapper;
import com.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: XiTao
 * @Date: 2018/12/22
 * @Field: 用户实现层
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    TUserMapper tum;
    @Override
    public List<TUser> selectUserIdIn(List<Integer> id) {
        TUserExample tue = new TUserExample();
        List<TUser> lu = new ArrayList<>();
        if (id !=null && id.size() !=0) {
            tue.or()
                    .andIdIn(id);
            lu = tum.selectByExample(tue);
        }
        return lu;
    }
}
