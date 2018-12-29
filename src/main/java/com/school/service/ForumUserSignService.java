package com.school.service;

import com.school.entity.TFkUserSign;

import java.util.List;

/**
 * Created by Administrator on 2018/12/28.
 */
public interface ForumUserSignService {

    /**
     * 查询 是否收藏过文章
     * @param userId 收藏人id
     * @param articleId 文章id
     * @return boolean
     */
    boolean selectMeWhetherSign(int userId, int articleId);

    /**
     * 删除 收藏过得文章
     * @param userId 收藏人id
     * @param articleId 文章id
     * @return boolean
     */
    boolean deleteSign(int userId, int articleId);

    /**
     * 添加 收藏文章
     * @param userId 收藏人id
     * @param articleId 文章Id
     * @return boolean
     */
    boolean addSign(int userId, int articleId);

    /**
     * 查询 收藏的条数
     * @param userId
     * @return
     */
    Long selectSignCount(int userId);

    /**
     * 查询 我收藏过的
     * @param userId
     * @return
     */
    List<TFkUserSign> selectMeSign(int userId);
}
