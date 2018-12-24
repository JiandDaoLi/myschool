package com.school.service.impl;

import com.school.entity.TCommentReply;
import com.school.entity.TCommentReplyExample;
import com.school.mapper.TCommentReplyMapper;
import com.school.service.ForumCommentReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: XiTao
 * @Date: 2018/12/23
 * @Field:评论回复实现层
 */
@Service
public class ForumCommentReplyServiceImpl  implements ForumCommentReplyService {
    @Autowired
    TCommentReplyMapper crm;

    @Override
    public List<TCommentReply> selectFkCommentIdToReply(int id) {
        TCommentReplyExample cre = new TCommentReplyExample();
        cre.or()
                .andFkForumCommentKeyEqualTo(id);
        List<TCommentReply> lcr = crm.selectByExample(cre);
        try {
            if (lcr != null && lcr.size() != 0) {
                return lcr;
            }
        } catch (Exception e) {
            return null;
        }finally {
            return null;
        }
    }

    @Override
    public boolean addReply(TCommentReply tcr) {
        boolean b = false;
        try {
            int  i = crm.insert(tcr);
            if (i != 0) {
                b = true;
            }
        }finally {
            return b;
        }
    }
}

