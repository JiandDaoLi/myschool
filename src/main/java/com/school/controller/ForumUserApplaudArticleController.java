package com.school.controller;

import com.school.service.ForumUserApplaudArticleService;
import com.school.service.ForumUserSignArticleService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: XiTao
 * @Date: 2018/12/24
 * @Field:
 */
@RequestMapping("/userApplaudArticle")
@RestController
public class ForumUserApplaudArticleController {
    @Autowired
    ForumUserApplaudArticleService uaas;

    @RequestMapping("/applaud")
    public boolean selectDeleteUserApplaudArticle(int userId, int articleId, int status) {
        boolean b = false;
        try {
           b =  uaas.addDeleteUserApplaudArticle(userId,articleId,status);
        } catch (Exception e) {
            return false;
        } finally {
            return b;
        }
    }

}
