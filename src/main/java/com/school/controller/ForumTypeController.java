package com.school.controller;

import com.school.entity.TForumType;
import com.school.entity.TUser;
import com.school.service.ForumArticleService;
import com.school.service.ForumTypeService;
import com.school.service.UserService;
import com.school.vo.TForumArticleVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Auther: XiTao
 * @Date: 2018/12/22
 * @Field: 论坛分类
 */
@RestController
@RequestMapping("/type")
public class ForumTypeController {
    Logger log = LoggerFactory.getLogger(ForumTypeController.class);
    @Autowired
    ForumTypeService forumTypeService;
    @Autowired
    UserService userService;
    @Autowired
    ForumArticleService forumArticleService;
    List<TForumType> lft = new ArrayList<>();

    ReadWriteLock rwl = new ReentrantReadWriteLock();

    @RequestMapping("/all")
    public ModelAndView selectForumTypeAll() {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        rwl.readLock().lock();
        try {
            if (lft.size() == 0) {
                rwl.readLock().unlock();
                if (lft.size() == 0) {
                    rwl.writeLock().lock();
                    lft = forumTypeService.selectForumTypeAll();
                    rwl.readLock().lock();
                    rwl.writeLock().unlock();
                }
            }
        } catch (Exception e) {
            log.info(e.toString());
        } finally {
            rwl.readLock().unlock();
            modelAndView.addObject("ftype", lft);
            return modelAndView;
        }
    }



    @RequestMapping("/option")
    public ModelAndView selectForumTypeOptioin() {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        List<TForumType> ltt = forumTypeService.selectForumTypeOption();
        modelAndView.addObject("ftype",ltt);
        return  modelAndView;

    }


}
