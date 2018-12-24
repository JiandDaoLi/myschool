package com.school.controller;

import com.school.service.ForumUserSignArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: XiTao
 * @Date: 2018/12/24
 * @Field:
 */
@RestController
@RequestMapping("/userSignArticle")
public class ForumUserSignArticleController {
    @Autowired
    ForumUserSignArticleService usas;

    @RequestMapping("/sign")
    public boolean selectDeleteUserApplaudArticle(int userId, int articleId, int status) {
        boolean b = false;
        try {
            b =  usas.addDeleteUserSignArticle(userId,articleId,status);
        } catch (Exception e) {
            return false;
        } finally {
            return b;
        }
    }
}
