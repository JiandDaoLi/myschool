package com.school.service;

import com.school.entity.TForumMind;

import java.util.List;

/**
 * @Auther: XiTao
 * @Date: 2018/12/23
 * @Field: 论坛关注的人
 */
public interface ForumMindService {
    /**
     * 添加关注的人
     * @param tForumMind
     * @return 添加成功否
     */
    boolean insertMeMindPerson(TForumMind tForumMind);

    /**
     * 查询关注的人 有多少
     * @param userId
     * @return
     */
    Long selectCountMindUser(int userId);

    /**
     * 查询我关注的人
     * @param userId
     * @return
     */
    List<TForumMind> selectMeMindUser(int userId);


}
