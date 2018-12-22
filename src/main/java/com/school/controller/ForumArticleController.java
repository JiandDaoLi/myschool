package com.school.controller;


import com.school.entity.TUser;
import com.school.service.ForumArticleService;
import com.school.service.UserService;
import com.school.util.StringUitl;
import com.school.vo.TForumArticleVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Founder XiTao
 * @Create_Data 2018/12/20
 * @Filde：论坛文章控制层
 */
@RestController
@RequestMapping("/forum")
public class ForumArticleController {
    Logger log = LoggerFactory.getLogger(ForumArticleController.class);
    @Autowired
    ForumArticleService fas;
    @Autowired
    UserService userService;
    ReadWriteLock rwl = new ReentrantReadWriteLock();


    /**
     * 根据标题查询Article中 标题and内容相匹配
     *
     * @param title
     * @return Article Json
     */
    @RequestMapping("/article/like")
    public ModelAndView findByTitleAndContentLikeToArticle(String title) {
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        List<TForumArticleVo> lfat = new ArrayList<>();
        try {
            if (title != null && !title.equals("")) {
                lfat = fas.findByTitleAndContentLikeToArticle(title);
            }
        } finally {

        }
        List<Integer> li = new ArrayList<>();
        for (TForumArticleVo tf : lfat) {
            try {
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
            } catch (Exception e) {
                log.info(e.toString());
            }finally {
            }
        }

        mav.addObject("farticle", lfat);
        return mav;
    }

    /**
     * 通过标题 equal Article and 相关文章
     * @param title
     * @return Article
     */
    @RequestMapping("/titleToArticle")
    public ModelAndView findByTitleToArticle(String title){
        ModelAndView modelAndView= new ModelAndView(new MappingJackson2JsonView());
        TForumArticleVo favo= fas.findByTitleToArticle(title);
        try {

            if (favo != null) {
                List<Integer> li = new ArrayList<>();
                li.add(favo.getFkUserKey().getId());
                List<TUser> lu = userService.selectUserIdIn(li);
                for (TUser tUser : lu) {
                    if (tUser.getId() == favo.getFkUserKey().getId()) {
                        favo.setFkUserKey(tUser);
                    }
                }
            }
        }finally {
            modelAndView.addObject("favo", favo);

            String titleUtil = StringUitl.aString(title);
            List<TForumArticleVo> taVO =  fas.findByTitleLikeLimite(titleUtil);
            if (taVO != null && taVO.size()!= 0) {
                List<Integer> li = new ArrayList<>();
                for (TForumArticleVo tavo : taVO) {
                    li.add(tavo.getFkUserKey().getId());
                }
                List<TUser> lu = userService.selectUserIdIn(li);
                for (TUser tUser : lu) {
                        for (TForumArticleVo tf : taVO) {
                            if (tUser.getId() == tf.getFkUserKey().getId()) {
                            while (tf.getFkUserKey().getId() == tUser.getId()) {
                                tf.setFkUserKey(tUser);
                                break;
                            }

                        }
                    }
                }
            }
            modelAndView.addObject("taVo", taVO);
            return modelAndView;
        }
    }
}
