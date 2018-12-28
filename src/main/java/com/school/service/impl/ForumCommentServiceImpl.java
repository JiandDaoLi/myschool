package com.school.service.impl;

import com.school.entity.TForumComment;
import com.school.entity.TForumCommentExample;
import com.school.mapper.TForumCommentMapper;
import com.school.service.ForumCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Auther: XiTao
 * @Date: 2018/12/22
 * @Field: 文章回复实现层
 */
@Service
public class ForumCommentServiceImpl implements ForumCommentService {
    @Autowired
    TForumCommentMapper fcm;
    List<TForumComment> lfc = new ArrayList<>();
    ReadWriteLock rwl = new ReentrantReadWriteLock();
    //多线程对同一个方法的成员变量进行操作 是可以控制的
    //多线程同时访问多个方法 每个方法都使用过这个成员变量  控制数据共享 而且 执行效率快
    @Override
    public List<TForumComment> selectFkIdToComment(int id) {
        TForumCommentExample fce = new TForumCommentExample();
        fce.or()
                .andFkForumArticleKeyEqualTo(id);
        lfc = fcm.selectByExample(fce);
        try {
            if (lfc != null && lfc.size() != 0) {
                return lfc;
            }
        }catch (Exception e) {
            return  null;
        }
            return null;

    }

    @Override
    public boolean addComment(TForumComment tForumComment) {
        boolean b = false;
        int i = 0;
        if (tForumComment != null) {
             i = fcm.insert(tForumComment);
        }
        if (i == 1) {
            b = true;
        }
        return b;
    }
}
