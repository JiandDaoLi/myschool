package com.school.controller;

import com.school.service.impl.ForumUserApplaudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/12/28.
 */
@RequestMapping("/applaud")
@RestController
public class ForumUserApplaudController {
    @Autowired
    ForumUserApplaudService service;
    boolean b = false;

    @RequestMapping("/add")
    public boolean addApplaud(int userId, int articleId){
        b = service.addApplaud(userId,articleId);
        return b;
    }
    @RequestMapping("/delete")
    public boolean deleteApplaud(int userId, int articleId){
        b = service.deleteApplaud(userId,articleId);
        return b;
    }

    @RequestMapping("/boolean")
    public boolean selectMeWhetherApplaud(int userId, int articleId){
        b = service.selectMeWhetherApplaud(userId,articleId);
        return b;
    }
}
