package com.school.controller;


import com.school.entity.TForumArticle;
import com.school.entity.TIntegralIco;
import com.school.entity.TUser;
import com.school.service.*;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    @Autowired
    ForumMindService mindService;
    @Autowired
    ForumFansService forumFansService;
    @Autowired
    IntegralIcoService inte;


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

           modelAndView.addObject("faVo",favo);
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

    @RequestMapping("/addViolation")
    public  boolean updateViolationCount(int articleId) {
       return fas.updateViolationCount(articleId);
    }
    @RequestMapping("/browseCount")
    public  ModelAndView  selectBrowseCount(int userId) {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        Integer count = fas.selectBrowseCountArticle(userId);
        modelAndView.addObject("browseCount", count);
        return modelAndView;
    }
    @RequestMapping("/articleCount")
    public  ModelAndView  selectArticleCount(int userId) {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        Long count = fas.selectArticleCount(userId);
        modelAndView.addObject("articleCount", count);
        return modelAndView;
    }
    @RequestMapping("/articleAllUser")
    public  ModelAndView  selectArticleAllUser(int userId) {
            ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
            List<TForumArticle> lfa = fas.selectArticleAll(userId);
            modelAndView.addObject("articleAll", lfa);
            return modelAndView;
    }

    @RequestMapping("/articleLimitUser")
    public  ModelAndView  selectArticleLimitUser(int userId) {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        List<TForumArticle> lfa = fas.selectLimitArticle(userId);
        modelAndView.addObject("articleLimit", lfa);
        return modelAndView;
    }

    @RequestMapping("/addArticle")
    public boolean addArticle(TForumArticle tForumArticle) {
        boolean b = false;
        try {
            if (tForumArticle != null) {
                b = fas.addArticle(tForumArticle);
            }
        } finally {
            return b;
        }

    }


    /**
     * 通过分类类型ID 查询 分类下的所有 文章
     *
     * @param id
     * @return
     */
    @RequestMapping("/singleTypeAll")
    public ModelAndView selectForumSingleType(int id) {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        List<TForumArticleVo> lfaVo = fas.findByFkTypeIdToArticle(id);
        if (lfaVo != null && lfaVo.size() != 0) {
            List<Integer> li = new ArrayList<>();
            for (TForumArticleVo tf : lfaVo) {
                li.add(tf.getFkUserKey().getId());
            }
            List<TUser> lu = userService.selectUserIdIn(li);
            for (TUser tu : lu) {
                for (TForumArticleVo favo : lfaVo) {
                    if (tu.getId() == favo.getFkUserKey().getId()) {
                        favo.setFkUserKey(tu);
                    }
                }
            }
        }
        modelAndView.addObject("lfavo", lfaVo);
        return modelAndView;
    }

    @RequestMapping("personalAll")
    public ModelAndView selectPersonalAll(int userId){
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        Map map = new HashMap();
        List<TForumArticle> lfa = fas.selectLimitArticle(userId);
        map.put("articleLimit", lfa);
        Long count = fas.selectArticleCount(userId);
        map.put("articleC", count);
        Integer count1 = fas.selectBrowseCountArticle(userId);
        map.put("browseC",count1);


        Long l1 = forumFansService.selectCountFansUser(userId);
        map.put("fansC",l1);
        List<Integer> li = new ArrayList<>();
        li.add(userId);
        List<TUser> tuser = userService.selectUserIdIn(li);
        TUser u = new TUser();
        for (TUser tUser : tuser) {
            u = tUser;
        }
        map.put("tuser",u);

        TIntegralIco tin = inte.selectFkIdICO(u.getFkIntegralId());
        map.put("inte",tin);


        Long l = mindService.selectCountMindUser(userId);
        map.put("mindC",l);
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

}
