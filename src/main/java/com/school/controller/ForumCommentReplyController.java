package com.school.controller;

import com.school.entity.TCommentReply;
import com.school.service.ForumCommentReplyService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

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
                List<TCommentReply> lcr = forumCommentReplyService.selectFkCommentIdToReply(id);

                if (lcr != null && lcr.size() != 0) {
                    modelAndView.addObject("lcr", lcr);
                }
            }
        }catch (Exception e) {

        }finally {
            return modelAndView;
        }
    }


}
