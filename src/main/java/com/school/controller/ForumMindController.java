package com.school.controller;

import com.school.entity.TForumMind;
import com.school.service.ForumMindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Auther: XiTao
 * @Date: 2018/12/23
 * @Field:添加关注的人
 */
@RequestMapping("/mind")
public class ForumMindController {
    @Autowired
    ForumMindService mindService;

    @RequestMapping("/addMind")
    public boolean addMind(int mindUserId, int decideUserId){
        TForumMind tForumMind = new TForumMind();
        tForumMind.setFkDecideUser(decideUserId);
        tForumMind.setFkMindUser(mindUserId);
        boolean b = mindService.insertMeMindPerson(tForumMind);
        return b;
    }

}
