package com.school.service;

import com.school.entity.TForumType;

import java.util.List;

/**
 * @Auther: XiTao
 * @Date: 2018/12/22
 * @Field:论坛类型分类
 */
public interface ForumTypeService {
    /**
     * 查询论坛类型分类
     * @return List TForumType
     */
    List<TForumType> selectForumTypeAll();

    List<TForumType> selectForumTypeOption();

}
