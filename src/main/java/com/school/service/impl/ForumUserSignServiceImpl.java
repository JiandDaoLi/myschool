package com.school.service.impl;

import com.school.entity.TFkUserSign;
import com.school.entity.TFkUserSignExample;
import com.school.mapper.TFkUserSignMapper;
import com.school.service.ForumUserSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/12/28.
 */
@Service
public class ForumUserSignServiceImpl implements ForumUserSignService {
    @Autowired
    TFkUserSignMapper tFkUserSignMapper;
    TFkUserSignExample tFkUserSignExample = new TFkUserSignExample();

    @Override
    public boolean selectMeWhetherSign(int userId, int articleId) {
        boolean b = false;
        tFkUserSignExample.or()
                .andFkArticleKeyEqualTo(articleId)
                .andFkUserKeyEqualTo(userId);
        List<TFkUserSign> list = tFkUserSignMapper.selectByExample(tFkUserSignExample);
        tFkUserSignExample.clear();
        if (list != null && list.size() != 0) {
            for (TFkUserSign tFkUserSign : list) {
                if (tFkUserSign.getStatus() == 1) {
                    b = true;
                }
            }

        }
        return b;
    }

    @Override
    public boolean deleteSign(int userId, int articleId) {
        boolean b = false;
        tFkUserSignExample.or()
                .andFkArticleKeyEqualTo(articleId)
                .andFkUserKeyEqualTo(userId);
        int i = tFkUserSignMapper.deleteByExample(tFkUserSignExample);
        if (i ==1){
            b = true;
        }
        return b;
    }

    @Override
    public boolean addSign(int userId, int articleId) {
        boolean b = false;
        TFkUserSign tFkUserSign = new TFkUserSign();
        tFkUserSign.setFkArticleKey(articleId);
        tFkUserSign.setFkUserKey(userId);
        tFkUserSign.setStatus(1);

        int i = tFkUserSignMapper.insert(tFkUserSign);
        if (i == 1) {
            b = true;
        }
        return b;
    }

    @Override
    public Long selectSignCount(int userId) {
        tFkUserSignExample.or()
                .andFkUserKeyEqualTo(userId);
       Long l  = tFkUserSignMapper.countByExample(tFkUserSignExample);

        return l;
    }

    @Override
    public List<TFkUserSign> selectMeSign(int userId) {
        tFkUserSignExample.clear();
        tFkUserSignExample.or()
                .andFkUserKeyEqualTo(userId);
        List<TFkUserSign> list = tFkUserSignMapper.selectByExample(tFkUserSignExample);
        tFkUserSignExample.clear();
        return list;
    }
}
