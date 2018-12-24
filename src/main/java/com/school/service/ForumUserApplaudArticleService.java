package com.school.service;

/**
 * @Auther: XiTao
 * @Date: 2018/12/24
 * @Field:
 */
public interface ForumUserApplaudArticleService  {
    /**
     *  0等于取消 ，1等于点赞
     * @param userId 点赞的人
     * @param articleId 点赞的文章
     * @param status 0 or 1 取消，点赞
     * @return boolean
     */
     boolean addDeleteUserApplaudArticle(int userId, int articleId, int status);

}
