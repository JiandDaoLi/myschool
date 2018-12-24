package com.school.service;

import com.school.entity.TForumMind;

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
}
