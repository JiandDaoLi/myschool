package com.school.controller;

import com.school.entity.TCommentReply;
import com.school.service.ForumCommentReplyService;
import com.school.util.StringUitl;
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
 * @Field:
 */
@RestController
@RequestMapping("/comment/reply")
public class ForumCommentReplyController {

    @Autowired
    ForumCommentReplyService forumCommentReplyService;
    @RequestMapping("/commentId")
    public ModelAndView selectFkCommentIdToReply(int id) {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        try {
            if (id != 0) {
                List<Integer> li = new ArrayList<>();
                li.add(id);
                List<TCommentReply> lcr = forumCommentReplyService.selectFkCommentIdToReply(li);

                if (lcr != null && lcr.size() != 0) {
                    modelAndView.addObject("lcr", lcr);
                }
            }
        }catch (Exception e) {

        }finally {
            return modelAndView;
        }
    }

    /**
     * 添加评论回复
     * @param commentKey 评论ID
     * @param content 评论回复内容
     * @param userId 评论回复用户ID
     * @return boolean
     */
    @RequestMapping("/add")
    public boolean addReply(int commentKey,String content, int userId) {
        TCommentReply tcr = new TCommentReply();
        boolean b = false;
        try {
            if (!StringUitl.stringFilter(content)) {
                tcr.setContentText(content);
                tcr.setFkForumCommentKey(commentKey);
                tcr.setFkUserKey(userId);

                b = forumCommentReplyService.addReply(tcr);
            }
        }catch (Exception e){
            return b;
        }
        return  b;
    }


}
