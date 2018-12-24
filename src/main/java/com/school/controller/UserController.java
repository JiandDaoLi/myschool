package com.school.controller;

import com.school.entity.TUser;
import com.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;


    @RequestMapping("/id")
    public ModelAndView selectFkUserIdToUser(int id){
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        List<Integer> li = new ArrayList<>();
        if (id != 0) {
            li.add(id);
           List<TUser> lu = userService.selectUserIdIn(li);
           lu.forEach(u ->{
               TUser user = u;
               modelAndView.addObject("tuser", user);
           });
        }
        return modelAndView;

    }

}
