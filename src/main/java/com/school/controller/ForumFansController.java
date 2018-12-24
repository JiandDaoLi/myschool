package com.school.controller;

import com.school.entity.TForumFans;
import com.school.service.ForumFansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;

/**
 * @Auther: XiTao
 * @Date: 2018/12/24
 * @Field:
 */
@RequestMapping("/fans")
@RestController
public class ForumFansController {

    @Autowired
    ForumFansService forumFansService;

    @RequestMapping("/countFans")
    public ModelAndView selectCountFansUser(int userId){
        Long l = forumFansService.selectCountFansUser(userId);
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        modelAndView.addObject("long",l);
        return  modelAndView;
    }

    @RequestMapping("/fansUser")
    public ModelAndView selectMeFansUser(int userId){
        List<TForumFans> lff = forumFansService.selectMeFansUser(userId);
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        modelAndView.addObject("meFansUser",lff);
        return  modelAndView;
    }

}
