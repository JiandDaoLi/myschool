package com.school.controller;


import com.school.entity.TForumArticle;
import com.school.entity.TUser;
import com.school.service.ForumArticleService;
import com.school.service.UserService;
import com.school.vo.TForumArticleVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.ArrayList;
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
    Logger log = LoggerFactory.getLogger(ForumArticleController.class);
    @Autowired
    ForumArticleService fas;
    @Autowired
    UserService userService;


    /**
     * 根据标题查询Article中 标题and内容相匹配
     * @param title
     * @return Article Json
     */
    @RequestMapping("/article/like")
    public ModelAndView findByTitleToArticle(String title) {
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        List<TForumArticleVo> lfat = fas.findByTitleToArticle(title);
        List<Integer> li = new ArrayList<>();
        for (TForumArticleVo tf : lfat) {
            try{
            if (tf.getFkUserKey() != null && tf.getFkUserKey().getId() > 0) {
                li.add(tf.getFkUserKey().getId());
                List<TUser> lu = userService.selectUserIdIn(li);
                for (TUser tu : lu) {
                    for (TForumArticleVo tfa : lfat) {
                        if (tu.getId() == tfa.getFkUserKey().getId()) {
                            tfa.setFkUserKey(tu);
                        }
                    }
                }
            }
            }catch (Exception e) {
                log.info(e.toString());
            }
        }


        mav.addObject("lfa", lfat);
        return mav;

    }
}
