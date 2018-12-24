package com.school.service;

/**
 * @Auther: XiTao
 * @Date: 2018/12/24
 * @Field:
 */
public interface ForumUserSignArticleService {

    /**
     * 删除收藏， 添加收藏
     * @param userId 收藏的人，删除的人
     * @param articleId 收藏的文章，删除收藏的文章
     * @param status 0 or 1 删除 ， 收藏
     * @return boolean
     */
    boolean addDeleteUserSignArticle(int userId, int articleId, int status);
}
