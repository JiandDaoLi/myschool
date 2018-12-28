package com.school.service.impl;

import com.school.entity.TForumMind;
import com.school.entity.TForumMindExample;
import com.school.mapper.TForumMindMapper;
import com.school.service.ForumMindService;
import com.school.util.IntUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: XiTao
 * @Date: 2018/12/23
 * @Field: 论坛关注实现层
 */
@Service
@Transactional
public class ForumMindServiceImpl implements ForumMindService {
    Logger log = LoggerFactory.getLogger(ForumMindServiceImpl.class);
    @Autowired
    TForumMindMapper fmm;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public boolean insertMeMindPerson(TForumMind tForumMind) {
        int i = 0;
        boolean b = false;
        if (tForumMind != null) {
            i = fmm.insert(tForumMind);
        }
        if (i == 1) {
            b = false;
        }
        return b;
    }

    @Override
    public Long selectCountMindUser(int userId) {
        TForumMindExample fme = new TForumMindExample();
        fme.or().andFkMindUserEqualTo(userId);
        return fmm.countByExample(fme);
    }

    @Override
    public List<TForumMind> selectMeMindUser(int userId) {
        TForumMindExample fme = new TForumMindExample();
        fme.or()
                .andFkMindUserEqualTo(userId);
        List<TForumMind> lfm = fmm.selectByExample(fme);


            return lfm;


    }

    @Override
    public boolean selectMeTrueFalseMindHe(int userId, int deId) {
        boolean b = false;
        TForumMindExample tForumMindExample = new TForumMindExample();
        tForumMindExample.or()
                .andFkMindUserEqualTo(userId)
                .andFkDecideUserEqualTo(deId);
       List<TForumMind> list =  fmm.selectByExample(tForumMindExample);
        if (list.size() != 0 && list != null) {
            b = true;
        }
        return b;
    }

    @Override
    public boolean deleteMind(int userId, int deId) {
        boolean b = false;
        TForumMindExample tForumMindExample = new TForumMindExample();
        tForumMindExample.or()
                .andFkMindUserEqualTo(userId)
                .andFkDecideUserEqualTo(deId);
        int  i = fmm.deleteByExample(tForumMindExample);
        b = IntUtil.addDeleteUpdate(i);


        return b;
    }
}
