package com.school.service.impl;

import com.school.entity.TForumType;
import com.school.entity.TForumTypeExample;
import com.school.mapper.TForumTypeMapper;
import com.school.service.ForumTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: XiTao
 * @Date: 2018/12/22
 * @Field:论坛类型分类实现层
 */
@Service
@Transactional
public class ForumTypeServiceImpl implements ForumTypeService {
    Logger log = LoggerFactory.getLogger(ForumTypeServiceImpl.class);
    @Autowired
    TForumTypeMapper ftm;

    @Override
    @Transactional(readOnly = true)
    public List<TForumType> selectForumTypeAll() {
        TForumTypeExample fte = new TForumTypeExample();
        List<TForumType> lft = new ArrayList<>();
        try {
            fte.or()
                    .andIdIsNotNull();
            lft = ftm.selectByExample(fte);
        } catch (Exception e) {
            log.info(e.toString());
        } finally {
            return lft;
        }

    }

    @Override
    public List<TForumType> selectForumTypeOption() {

        TForumTypeExample fte = new TForumTypeExample();
        List<TForumType> lft = new ArrayList<>();
        List<String> ls = new ArrayList<>();
        ls.add("最新");
        ls.add("推荐");
        try {
            fte.or()
                    .andClassifyNotIn(ls);
            lft = ftm.selectByExample(fte);
        } catch (Exception e) {
            log.info(e.toString());
        }
        return lft;
    }
}
