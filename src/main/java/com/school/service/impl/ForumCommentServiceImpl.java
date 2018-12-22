package com.school.service.impl;

import com.school.entity.TForumComment;
import com.school.mapper.TForumCommentMapper;
import com.school.service.ForumCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * @Auther: XiTao
 * @Date: 2018/12/22
 * @Field: 文章回复实现层
 */
@Transactional
@Service
public class ForumCommentServiceImpl implements ForumCommentService {
    @Autowired
    TForumCommentMapper fcm;
    @Transactional(readOnly = true)
    @Override
    public List<TForumComment> selectFkIdToComment(int id) {
        List<TForumComment> lfc = new ArrayList<>();
        return null;
    }
}
