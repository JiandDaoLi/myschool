package com.school.service;

import com.school.entity.TForumFans;

import java.util.List;

/**
 * @Auther: XiTao
 * @Date: 2018/12/24
 * @Field:
 */
public interface ForumFansService {
    /**
     * 查询粉丝 数量
     * @param userId
     * @return Long
     */
    Long selectCountFansUser(int userId);

    /**
     * 查询粉丝 用户
     * @param userId
     * @return  List<TForumFans>
     */
    List<TForumFans> selectMeFansUser(int userId);

    /**
     * 添加粉丝
     * @param userId 主动关注的人
     * @param decideId 被动关注的人
     * @return
     */
    boolean addFans(int userId, int decideId);

    boolean selectMeTrueFalseFans(int userId, int decideId);

    boolean deleteFans(int userId, int decideId);
}
