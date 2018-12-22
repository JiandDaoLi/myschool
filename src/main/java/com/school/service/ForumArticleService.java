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

}
