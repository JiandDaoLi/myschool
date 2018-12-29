package com.school.controller;

import com.school.entity.TForumComment;
import com.school.service.ForumArticleService;
import com.school.service.ForumCommentService;
import com.school.util.StringUitl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: XiTao
 * @Date: 2018/12/22
 * @Field:
 */
@RequestMapping("/comment")
@RestController
public class ForumCommentController {

    @Autowired
    ForumCommentService forumCommentService;
    @Autowired
    ForumArticleService forumArticleService;
    List<TForumComment> list = new ArrayList<>();

    @RequestMapping("/toId")
    public ModelAndView selectFkArticleIdComment(int id) {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());


        list = forumCommentService.selectFkIdToComment(id);


        modelAndView.addObject("comment", list);
        return modelAndView;
    }


    @RequestMapping("/toIId")
    public ModelAndView selectFkArticleIdCom(int id) {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());


        list = forumCommentService.selectFkIdToComment(id);


        modelAndView.addObject("comment", list);
        return modelAndView;
    }

    /**
     * 添加评论
     * @param articleId 文章
     * @param userId 评论人
     * @param rank 楼
     * @param content 内容
     * @return boolean
     */
    @RequestMapping("/addComment")
    public boolean addComment(
            int articleId, int userId, int rank, String content) {
        boolean b = false;
        TForumComment tfc = new TForumComment();
        if (articleId != 0 && userId != 0 && content!= null) {
            tfc.setCreateTime(new Date());
            tfc.setFkForumArticleKey(articleId);
            tfc.setFkUserKey(userId);
            tfc.setRanks(StringUitl.getRank(rank));
            b  = forumCommentService.addComment(tfc);
        }
        if (b) {
           b =  forumArticleService.updateCommentCount(articleId);
        }
        return  b ;
    }

}
