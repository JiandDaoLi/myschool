package com.school.service;

import com.school.entity.TUser;

import java.util.List;

/**
 * @Auther: XiTao
 * @Date: 2018/12/22
 * @Field: User Service
 */
public interface UserService {
    /**
     *  通过Id获取IN（包含的User对象
     * @param  id
     * @return List User
     */
    List<TUser> selectUserIdIn(List<Integer> id);
}
