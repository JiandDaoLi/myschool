package com.school.service.impl;

import com.school.entity.TFkArticleUserApplaudStatus;
import com.school.entity.TFkArticleUserApplaudStatusExample;
import com.school.mapper.TFkArticleUserApplaudStatusMapper;
import com.school.service.ForumUserApplaudArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: XiTao
 * @Date: 2018/12/24
 * @Field: Article 点赞 实现类
 */
@Service
public class ForumUserAppluadArticleServiceImpl implements ForumUserApplaudArticleService {
    @Autowired
    TFkArticleUserApplaudStatusMapper uatm;

    @Override
    public boolean addDeleteUserApplaudArticle(int userId, int articleId, int status) {
        boolean b = false;
        int i = 0;
        TFkArticleUserApplaudStatusExample uase = new TFkArticleUserApplaudStatusExample();
        uase.or()
                .andFkArticleKeyEqualTo(articleId)
                .andFkUserKeyEqualTo(userId);
        try {
            List<TFkArticleUserApplaudStatus> lfus = uatm.selectByExample(uase);
            if (status == 0) {
                if (lfus != null && lfus.size() != 0) {
                    i = uatm.deleteByPrimaryKey(lfus.get(0).getId());
                    if (i != 0) {
                        b = true;
                    }
                }

            } else if (status == 1) {
                TFkArticleUserApplaudStatus aua = new TFkArticleUserApplaudStatus();
                aua.setFkArticleKey(articleId);
                aua.setFkUserKey(userId);
                aua.setStatus(status);
                i = uatm.insert(aua);
                if (i != 0) {
                    b = true;
                }
            } else {
                b = false;
            }
        } catch (Exception e) {
            return false;
        } finally {
            return b;
        }

    }
}
