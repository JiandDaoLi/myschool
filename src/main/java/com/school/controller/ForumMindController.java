package com.school.controller;

import com.school.entity.TForumMind;
import com.school.service.ForumFansService;
import com.school.service.ForumMindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;

/**
 * @Auther: XiTao
 * @Date: 2018/12/23
 * @Field:添加关注的人
 */
@RequestMapping("/mind")
public class ForumMindController {
    @Autowired
    ForumMindService mindService;
    @Autowired
    ForumFansService fansService;

    @RequestMapping("/addMind")
    public boolean addMind(int mindUserId, int decideUserId){
        TForumMind tForumMind = new TForumMind();
        tForumMind.setFkDecideUser(decideUserId);
        tForumMind.setFkMindUser(mindUserId);
        boolean b = mindService.insertMeMindPerson(tForumMind);
        if (b) {
            b = fansService.addFans(decideUserId,mindUserId);
        }
        return b;
    }

    @RequestMapping("/mindCount")
    public ModelAndView selectMeMindUserCount(int userId) {
        Long l = mindService.selectCountMindUser(userId);
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        modelAndView.addObject("mindCount",l);
        return modelAndView;
    }

    @RequestMapping("/mindUser")
    public ModelAndView selectMeMindUser(int userId) {
        List<TForumMind> lfm = mindService.selectMeMindUser(userId);
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        modelAndView.addObject("mindUser", lfm);
        return modelAndView;
    }

}
