package com.school.service.impl;

import com.school.entity.TForumFans;
import com.school.entity.TForumFansExample;
import com.school.mapper.TForumFansMapper;
import com.school.service.ForumFansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: XiTao
 * @Date: 2018/12/24
 * @Field:
 */
@Service
public class ForumFansServiceImpl implements ForumFansService {
    @Autowired
    TForumFansMapper ffm;

    @Override
    public Long selectCountFansUser(int userId) {
        TForumFansExample ffe = new TForumFansExample();
        ffe.or().andFkDecideUserEqualTo(userId);
        return ffm.countByExample(ffe);
    }

    @Override
    public List<TForumFans> selectMeFansUser(int userId) {
        TForumFansExample ffe = new TForumFansExample();
        ffe.or().andFkDecideUserEqualTo(userId);
        List<TForumFans> lff = new ArrayList<>();
        try {
                lff = ffm.selectByExample(ffe);

        } finally {
            return lff;
        }
    }

    @Override
    public boolean addFans(int userId, int decideId) {
        boolean b = false;
        int i = 0;
        TForumFans ff = new TForumFans();
        try {
            ff.setFkDecideUser(decideId);
            ff.setFkFansUser(userId);
            i =ffm.insert(ff);
            if (i != 0) {
                b = true;
            }
        }finally {
            return b;
        }

    }
}
