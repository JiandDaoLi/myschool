package com.school.mapper;

import com.school.entity.TForumMind;
import com.school.entity.TForumMindExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TForumMindMapper {
    long countByExample(TForumMindExample example);

    int deleteByExample(TForumMindExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TForumMind record);

    int insertSelective(TForumMind record);

    List<TForumMind> selectByExample(TForumMindExample example);

    TForumMind selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TForumMind record, @Param("example") TForumMindExample example);

    int updateByExample(@Param("record") TForumMind record, @Param("example") TForumMindExample example);

    int updateByPrimaryKeySelective(TForumMind record);

    int updateByPrimaryKey(TForumMind record);
}