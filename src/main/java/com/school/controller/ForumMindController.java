package com.school.controller;

import com.school.entity.TForumFans;
import com.school.entity.TForumMind;
import com.school.entity.TUser;
import com.school.service.ForumFansService;
import com.school.service.ForumMindService;
import com.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: XiTao
 * @Date: 2018/12/23
 * @Field:添加关注的人
 */
@RequestMapping("/mind")
@RestController
public class ForumMindController {
    @Autowired
    ForumMindService mindService;
    @Autowired
    ForumFansService fansService;
    @Autowired
    UserService userService;

    @RequestMapping("/addMind")
    public boolean addMind(int mindUserId, int decideUserId){
        boolean b = false;
        b = mindService.selectMeTrueFalseMindHe(mindUserId,decideUserId);
        if (!b) {
            TForumMind tForumMind = new TForumMind();
            tForumMind.setFkDecideUser(decideUserId);
            tForumMind.setFkMindUser(mindUserId);
             mindService.insertMeMindPerson(tForumMind);

            fansService.selectMeTrueFalseFans(mindUserId,decideUserId);

              b = fansService.addFans(mindUserId,decideUserId);





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
        List<TForumFans> lff = fansService.selectMeFansUser(userId);
        List<Integer> mli = new ArrayList<>();
        for (TForumMind tForumMind : lfm) {
            mli.add(tForumMind.getFkDecideUser());
        }

        List<TUser> mlu  = userService.selectUserIdIn(mli);
        List<Integer> fli = new ArrayList<>();
        for (TForumFans tForumFans : lff) {
            fli.add(tForumFans.getFkFansUser());
        }
        List<TUser> flu = userService.selectUserIdIn(fli);

        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        modelAndView.addObject("mUser",mlu);
        modelAndView.addObject("fUser",flu);

        modelAndView.addObject("mindUser", lfm);

        modelAndView.addObject("meFansUser",lff);
        return modelAndView;
    }

    @RequestMapping("/booleanMind")
    public boolean selectMeTrueFalseMindHe(int userId, int deId){
       return   mindService.selectMeTrueFalseMindHe(userId,deId);
    }

}
