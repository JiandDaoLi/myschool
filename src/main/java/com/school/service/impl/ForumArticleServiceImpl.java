package com.school.service.impl;

import com.school.entity.TForumArticle;
import com.school.entity.TForumArticleExample;
import com.school.entity.TUser;
import com.school.mapper.TForumArticleMapper;
import com.school.service.ForumArticleService;
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
        Map<String,Object> map = new HashMap<>();
        map.put("title", likeTitle);
        if (lone != null && lone.size() !=0) {
            List<String> ls = new ArrayList<>();
            for (TForumArticle tf : lone) {
                ls.add(tf.getTitle());
            }
            map.put("map", ls);
        }
        List<TForumArticle> lthree = tam.selectLikeTitleNotIn(map);
        if (lthree != null && lthree.size() !=0) {
            for (TForumArticle tf : lthree) {
                lfa.add(get(tf));
            }
        }
        //%内容%
        map = new HashMap<>();
        map.put("content_text", likeTitle);
        if (ltwo != null && ltwo.size() !=0) {
            List<String> ls = new ArrayList<>();
            for (TForumArticle tf : ltwo) {
                ls.add(tf.getContentText());
            }
            map.put("map", ls);
        }
        List<TForumArticle> lfour = tam.selectLikeContentNotIn(map);
        if (lfour != null && lfour.size() !=0) {
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

        }catch (Exception e) {

        }finally {
            return lfaVo;
        }
    }
    @Override
    public  List<TForumArticleVo> findByTitleLikeLimite(String title) {
        return null;
    }

    private TForumArticleVo get(TForumArticle tf) {
        TForumArticleVo avo = new TForumArticleVo();
        avo.setId(tf.getId());
        avo.setApplaud(tf.getApplaud());
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
