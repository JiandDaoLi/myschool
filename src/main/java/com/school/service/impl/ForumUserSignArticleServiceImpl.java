package com.school.service.impl;

import com.school.entity.TFkUserSign;
import com.school.entity.TFkUserSignExample;
import com.school.mapper.TFkUserSignMapper;
import com.school.service.ForumUserSignArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: XiTao
 * @Date: 2018/12/24
 * @Field:
 */
@Service
public class ForumUserSignArticleServiceImpl implements ForumUserSignArticleService {
    @Autowired
    TFkUserSignMapper fsm;
    @Override
    public boolean addDeleteUserSignArticle(int userId, int articleId, int status) {
        boolean b = false;
        int i = 0;
        TFkUserSignExample fse = new TFkUserSignExample();
        fse.or()
                .andFkArticleKeyEqualTo(articleId)
                .andFkUserKeyEqualTo(userId);

        try {
            List<TFkUserSign> lfus=  fsm.selectByExample(fse);
            if (status == 0) {
                if (lfus != null && lfus.size() != 0) {
                    i = fsm.deleteByPrimaryKey(lfus.get(0).getId());
                    if (i != 0) {
                        b = true;
                    }
                }

            }else if (status == 1) {
                TFkUserSign fu = new TFkUserSign();
                fu.setFkArticleKey(articleId);
                fu.setFkUserKey(userId);
                fu.setStatus(status);
                i = fsm.insert(fu);
                if (i != 0) {
                    b = true;
                }
            }else {
                b = false;
            }
        }catch (Exception e) {
            return false;
        }
        finally {
            return b;
        }



    }
}
