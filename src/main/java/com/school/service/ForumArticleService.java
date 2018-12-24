package com.school.service;


import com.school.entity.TForumArticle;
import com.school.vo.TForumArticleVo;

import java.util.List;

/**
 * @Auther: XiTao
 * @Date: 2018/12/20
 * @Filde: 论坛文章Service
 */
public interface ForumArticleService {
    /**
     * select Article
     * @param likeTitle article title
     * @return List<TForumArticleVo>
     */
    List<TForumArticleVo> findByTitleAndContentLikeToArticle(String likeTitle);

    /**
     * select fk_forum_type_id article
     * @param id fk_forum_type_key
     * @return List<TForumArticleVo>
     */
    List<TForumArticleVo> findByFkTypeIdToArticle(int id);

    /**
     * select article
     * @param title article
     * @return TForumArticle
     */
    TForumArticleVo findByTitleToArticle(String title);

    /**
     * Titile限制条数返回Article
     * @param title
     * @return
     */
    List<TForumArticleVo> findByTitleLikeLimite(String title);

    /**
     * 评论量
     * @param articleId 文章ID
     * @return boolean
     */
    boolean updateCommentCount(int articleId);

    /**
     * 点赞 or 取消
     * @param articleId 文章Id
     * @param applaudInt 如果是1就加1 如果是-1就减去1
     * @return boolean
     */
    boolean updateApplaudCount(int articleId, int applaudInt);
    /**
     * 举报验证
     * @param articleId 文章ID
     * @return boolean
     */
    boolean updateViolationCount(int articleId);

}
