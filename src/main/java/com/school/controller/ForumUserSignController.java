package com.school.controller;

import com.school.service.ForumUserSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/12/28.
 */
@RestController
@RequestMapping("/sign")
public class ForumUserSignController {
    @Autowired
    ForumUserSignService forumUserSignService;
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


}
