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
     * @param title
     * @return TForumArticle.class
     */
    List<TForumArticleVo> findByTitleToArticle(String title);

}
