package com.school.controller;


import com.school.entity.*;
import com.school.finals.FinalsString;
import com.school.service.*;
import com.school.util.StringUitl;
import com.school.util.UpLoadUtil;
import com.school.vo.TForumArticleVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
    @Autowired
    ForumCommentService forumCommentService;
    @Autowired
    ForumCommentReplyService forumCommentReplyService;
    @Autowired
    ForumUserSignService forumUserSignService;


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
     * 通过标题 equal Article and 相关文章 评论内容 回复内容
     * @param title
     * @return Article
     */
    @RequestMapping("/titleToArticle")
    public ModelAndView findByTitleToArticle(String title){
        ModelAndView modelAndView= new ModelAndView(new MappingJackson2JsonView());
        //这篇文章
        TForumArticleVo favo= fas.findByTitleToArticle(title);
        int fk =0;
        try {
           if (favo != null) {
                List<Integer> li = new ArrayList<>();
                li.add(favo.getFkUserKey().getId());
                List<TUser> lu = userService.selectUserIdIn(li);

                for (TUser tUser : lu) {
                    if (tUser.getId() == favo.getFkUserKey().getId()) {
                        favo.setFkUserKey(tUser);
                        fk = tUser.getFkIntegralId();
                    }
                }
            }

        }finally {
            //用户等级图标
           TIntegralIco tii = inte.selectFkIdICO(fk);
            modelAndView.addObject("tii",tii);
           modelAndView.addObject("faVo",favo);


            Map  map = new HashMap();

           //评论查询
            List<TForumComment> lfc = forumCommentService.selectFkIdToComment(favo.getId());
            map.put("lfcomment",lfc);
            //评论人
            List<Integer> lit = new ArrayList<>();
            for (TForumComment fc : lfc) {
                lit.add(fc.getId());
            }

            List<TUser> luserComment =  userService.selectUserIdIn(lit);
            map.put("userComment",luserComment);
            //评论回复查询
            List<TCommentReply> lcr = forumCommentReplyService.selectFkCommentIdToReply(lit);
            map.put("lcreply",lcr);
            //评论回复人
            List<Integer> litg = new ArrayList<>();
            for (TCommentReply tCommentReply : lcr) {
                litg.add(tCommentReply.getFkUserKey());
            }
            List<TUser> luserReply =  userService.selectUserIdIn(litg);
            map.put("userReply",luserReply);
           //相关文章推荐
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

            modelAndView.addAllObjects(map);
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
    public  boolean addArticle(TForumArticle tForumArticle ) {
        //文件目录
        String path = FinalsString.PROJECT_STATIC_RESOURCE_PATH_TEXT;
        //文件名称
        String fileName = path+"/"+StringUitl.createStringRandomName();
        boolean b = UpLoadUtil.writeDataInServlet(tForumArticle.getContentText(), fileName);
        if (b){
           tForumArticle.setContentText(fileName);
        }
        if (tForumArticle != null) {
            b = fas.addArticle(tForumArticle);
        }
        return b;

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

        Long signL = forumUserSignService.selectSignCount(userId);
        map.put("signC",signL);
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

}
