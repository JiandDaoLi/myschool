package com.school.service.impl;

import com.school.entity.TForumArticle;
import com.school.entity.TForumArticleExample;
import com.school.entity.TForumComment;
import com.school.entity.TUser;
import com.school.mapper.TForumArticleMapper;
import com.school.service.ForumArticleService;
import com.school.util.StringUitl;
import com.school.vo.TForumArticleVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Auther: XiTao
 * @Date: 2018/12/20
 * @Field: 论坛文章 实现层
 */
@Transactional
@Service
public class ForumArticleServiceImpl implements ForumArticleService {
    Logger log = LoggerFactory.getLogger(ForumArticleServiceImpl.class);
    @Autowired
    TForumArticleMapper tam;
    ReadWriteLock rwl = new ReentrantReadWriteLock();

    /**
     * 查询文章
     *
     * @param likeTitle
     * @return List<TForumArticle>
     */
    public List<TForumArticleVo> findByTitleAndContentLikeToArticle(String likeTitle) {
        TForumArticleExample tae = new TForumArticleExample();
        List<TForumArticleVo> lfa = new ArrayList<>();

        //标题equal
        List<TForumArticle> lone = new ArrayList<>();
        tae.or()
                .andTitleEqualTo(likeTitle);
        lone = tam.selectByExample(tae);
        if (lone != null && lone.size() != 0) {
            for (TForumArticle tf : lone) {
                lfa.add(get(tf));
            }
        }
        //内容equal
        tae = new TForumArticleExample();
        tae.or()
                .andContentTextEqualTo(likeTitle);
        List<TForumArticle> ltwo = tam.selectByExample(tae);
        if (ltwo != null && ltwo.size() != 0) {
            for (TForumArticle tf : ltwo) {
                lfa.add(get(tf));
            }
            tae = new TForumArticleExample();
        }
        //%标题%
        Map<String, Object> map = new HashMap<>();
        map.put("title", likeTitle);
        if (lone != null && lone.size() != 0) {
            List<String> ls = new ArrayList<>();
            for (TForumArticle tf : lone) {
                ls.add(tf.getTitle());
            }
            map.put("map", ls);
        }
        List<TForumArticle> lthree = tam.selectLikeTitleNotIn(map);
        if (lthree != null && lthree.size() != 0) {
            for (TForumArticle tf : lthree) {
                lfa.add(get(tf));
            }
        }
        //%内容%
        map = new HashMap<>();
        map.put("content_text", likeTitle);
        if (ltwo != null && ltwo.size() != 0) {
            List<String> ls = new ArrayList<>();
            for (TForumArticle tf : ltwo) {
                ls.add(tf.getContentText());
            }
            map.put("map", ls);
        }
        List<TForumArticle> lfour = tam.selectLikeContentNotIn(map);
        if (lfour != null && lfour.size() != 0) {
            for (TForumArticle tf : lfour) {
                lfa.add(get(tf));
            }
        }
        return lfa;

    }

    @Override
    public List<TForumArticleVo> findByFkTypeIdToArticle(int id) {
        TForumArticleExample fae = new TForumArticleExample();
        List<TForumArticle> lfa = new ArrayList<>();
        List<TForumArticleVo> lfavO = new ArrayList<>();
        fae.or()
                .andFkUserKeyEqualTo(id);
        lfa = tam.selectByExample(fae);
        for (TForumArticle tf : lfa) {
            lfavO.add(get(tf));
        }
        return lfavO;
    }

    @Override
    public TForumArticleVo findByTitleToArticle(String title) {
        TForumArticleExample fae = new TForumArticleExample();
        fae.or()
                .andTitleEqualTo(title);
        List<TForumArticle> lfa = tam.selectByExample(fae);
        TForumArticleVo lfaVo = null;
        try {
            for (TForumArticle tf : lfa) {
                lfaVo = get(tf);
            }

        } catch (Exception e) {

        } finally {
            return lfaVo;
        }
    }

    @Override
    public List<TForumArticleVo> findByTitleLikeLimite(String title) {
        TForumArticleExample fae = new TForumArticleExample();
        List<TForumArticleVo> lfaVo = new ArrayList<>();
        fae.or()
                .andTitleLike("%" + title + "%");
        List<TForumArticle> lfa = tam.selectByExample(fae);
        if (lfa != null && lfa.size() != 0) {
            if (lfa.size() >= 6) {
                for (int i = 0; i < 5; i++) {
                    lfaVo.add(get(lfa.get(i)));
                }
            } else if (lfa.size() <= 5) {
                for (TForumArticle tf : lfa) {
                    lfaVo.add(get(tf));
                }
            }

        }

        return lfaVo;
    }

    @Override
    public boolean updateCommentCount(int articleId) {
        boolean b = false;
        try {
            TForumArticleExample fae = new TForumArticleExample();
            fae.or().andIdEqualTo(articleId);
            List<TForumArticle> lfa = tam.selectByExample(fae);
            TForumArticle tfa = new TForumArticle();
            lfa.forEach(f -> {
                tfa.setId(articleId);
                tfa.setCommentCount(f.getCommentCount() + 1);
            });
            int i = tam.updateByPrimaryKey(tfa);
            if (i != 0) {
                b = true;
            }
        } finally {
            return b;
        }


    }

    @Override
    public boolean updateViolationCount(int articleId) {
        final boolean[] b = {false};
        TForumArticleExample fae = new TForumArticleExample();
        fae.or()
                .andIdEqualTo(articleId);
        List<TForumArticle> lfae = tam.selectByExample(fae);
        final Integer[] count = {1};
        TForumArticle fa = new TForumArticle();
        final int[] i = {0};
        try {
            lfae.forEach(f -> {
                if (StringUitl.stringFilter(f.getTitle()) && StringUitl.stringFilter(f.getContentText())) {
                    count[0] = count[0] + f.getViolationCount();
                    fa.setId(articleId);
                    fa.setViolationCount(count[0]);
                    i[0] = tam.updateByPrimaryKey(fa);
                } else {
                    b[0] = false;
                }
            });

            if (i[0] != 0) {
                b[0] = true;
            }
        } finally {
            return b[0];
        }
    }

    @Override
    public Integer selectBrowseCountArticle(int userId) {
        Integer i = 0;
        try {
            i = tam.selectBrowseCount(userId);
        } finally {
           return  i;
        }
    }

    @Override
    public List<TForumArticle> selectArticleAll(int userId) {
        TForumArticleExample fae = new TForumArticleExample();
        fae.or().andFkUserKeyEqualTo(userId);
        List<TForumArticle> lfa = tam.selectByExample(fae);

        return lfa;
    }

    @Override
    public List<TForumArticle> selectLimitArticle(int userId) {
        return tam.selectLimitArticle(userId);
    }

    @Override
    public Long selectArticleCount(int userId) {
        TForumArticleExample fae = new TForumArticleExample();
        fae.or().andFkUserKeyEqualTo(userId);
        return tam.countByExample(fae);
    }

    @Override
    public boolean addArticle(TForumArticle tForumArticle) {
        boolean b = false;
        int i =tam.insert(tForumArticle);
        if (i != 0 ) {
            b = true;
        }
        return b;
    }


    private TForumArticleVo get(TForumArticle tf) {
        TForumArticleVo avo = new TForumArticleVo();
        avo.setId(tf.getId());
        avo.setApplaud(tf.getFkApplaudStatus());
        avo.setContentText(tf.getContentText());
        avo.setCommentCount(tf.getCommentCount());
        avo.setCreateTime(tf.getCreateTime());
        avo.setViolationCount(tf.getViolationCount());
        avo.setTitle(tf.getTitle());
        TUser u = new TUser();
        u.setId(tf.getId());
        avo.setFkUserKey(u);
        avo.setFkForumTypeKey(tf.getFkForumTypeKey());
        avo.setBrowseConut(tf.getBrowseConut());
        return avo;

    }

}
