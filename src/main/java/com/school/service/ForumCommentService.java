package com.school.service;

import com.school.entity.TForumComment;

import java.util.List;

/**
 * @Auther: XiTao
 * @Date: 2018/12/22
 * @Field: 文章回复Service
 */
public interface ForumCommentService {
    /**
     * 通过FK_Article_Key查询Comment
     * @param id
     * @return
     */
    List<TForumComment> selectFkIdToComment(int id);

}
