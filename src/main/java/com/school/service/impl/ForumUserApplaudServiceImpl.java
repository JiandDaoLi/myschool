package com.school.service.impl;

import com.school.entity.TFkArticleUserApplaudStatus;
import com.school.entity.TFkArticleUserApplaudStatusExample;
import com.school.mapper.TFkArticleUserApplaudStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/12/28.
 */
@Service
public class ForumUserApplaudServiceImpl implements ForumUserApplaudService {
    @Autowired
    TFkArticleUserApplaudStatusMapper mapper;
    TFkArticleUserApplaudStatusExample example = new TFkArticleUserApplaudStatusExample();
    boolean b = false;
    int i = 0;
    @Override
    public boolean selectMeWhetherApplaud(int userId, int articleId) {
        example.clear();
        example.or()
                .andFkUserKeyEqualTo(userId)
                .andFkArticleKeyEqualTo(articleId);
        List<TFkArticleUserApplaudStatus> list = mapper.selectByExample(example);
        if (list != null && list.size() != 0) {
            b = true;
        }
        example.clear();
        return b;
    }

    @Override
    public boolean addApplaud(int userId, int articleId) {
        example.clear();
        TFkArticleUserApplaudStatus tFkArticleUserApplaudStatus = new TFkArticleUserApplaudStatus();
        tFkArticleUserApplaudStatus.setStatus(1);
        tFkArticleUserApplaudStatus.setFkUserKey(userId);
        tFkArticleUserApplaudStatus.setFkArticleKey(articleId);
        i  = mapper.insert(tFkArticleUserApplaudStatus);
        if (i != 0) {
            b = true;
        }
        example.clear();
        return b;
    }

    @Override
    public boolean deleteApplaud(int userId, int articleId) {
        example.clear();
        example.or()
                .andFkArticleKeyEqualTo(articleId)
                .andFkUserKeyEqualTo(userId);
         i = mapper.deleteByExample(example);
        if (i != 0) {
            b = true;
        }
        return b;
    }
}
