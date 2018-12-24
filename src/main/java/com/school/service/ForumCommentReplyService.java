package com.school.service;

import com.school.entity.TCommentReply;

import java.util.List;

/**
 * @Auther: XiTao
 * @Date: 2018/12/23
 * @Field: 评论回复
 */
public interface ForumCommentReplyService {

    /**
     * 通过fk_comment_key查询 Comment Reply
     * @param id
     * @return
     */
    List<TCommentReply> selectFkCommentIdToReply(int id);

    boolean addReply(TCommentReply tcr);
}
