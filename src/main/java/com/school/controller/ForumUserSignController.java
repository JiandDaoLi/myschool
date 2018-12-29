package com.school.controller;

import com.school.entity.TFkUserSign;
import com.school.entity.TForumArticle;
import com.school.service.ForumArticleService;
import com.school.service.ForumUserSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/12/28.
 */
@RestController
@RequestMapping("/sign")
public class ForumUserSignController {
    @Autowired
    ForumUserSignService forumUserSignService;
    @Autowired
    ForumArticleService forumArticleService;

    boolean b = false;

    @RequestMapping("/boolean")
    public boolean selectMeWhetherSign(int userId, int articleId){

      b =   forumUserSignService.selectMeWhetherSign(userId,articleId);
      return  b;

    }

    @RequestMapping("/add")
    public boolean addSign(int userId, int articleId){
        b =   forumUserSignService.addSign(userId,articleId);
        return  b;

    }

    @RequestMapping("/delete")
    public boolean deleteSign(int userId, int articleId){
        b =   forumUserSignService.deleteSign(userId,articleId);
        return  b;

    }

    @RequestMapping("/meSign")
    public ModelAndView selectMeSign(int userId){
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        List<TFkUserSign> uSign =  forumUserSignService.selectMeSign(userId);
        List<Integer> li  = new ArrayList<>();
        for (TFkUserSign tFkUserSign : uSign) {
            li.add(tFkUserSign.getFkArticleKey());
        }
       List<TForumArticle> lfa =  forumArticleService.selectFindById(li);
        modelAndView.addObject("articleAll",lfa);
        return modelAndView;
    }


}
