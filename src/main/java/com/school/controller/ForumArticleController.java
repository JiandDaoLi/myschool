package com.school.controller;


import com.school.entity.TForumArticle;
import com.school.service.ForumArticleService;
import com.school.vo.TForumArticleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@Founder XiTao
 *@Create_Data 2018/12/20
 * @Filde：论坛文章控制层
 */
@RestController
@RequestMapping( "/forum" )
public class ForumArticleController {
    @Autowired
    ForumArticleService fas;

    /**
     * 根据标题查询Article中 标题and内容相匹配
     * @param title
     * @return Article Json
     */
    @RequestMapping("/article/like")
    public ModelAndView findByTitleToArticle(String title) {
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        List<TForumArticleVo> lfat = fas.findByTitleToArticle(title);
        mav.addObject("lfa", lfat);
        return mav;

    }
}
