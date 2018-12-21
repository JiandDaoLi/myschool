package com.school.mapper;

import com.school.entity.TForumSign;
import com.school.entity.TForumSignExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TForumSignMapper {
    long countByExample(TForumSignExample example);

    int deleteByExample(TForumSignExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TForumSign record);

    int insertSelective(TForumSign record);

    List<TForumSign> selectByExample(TForumSignExample example);

    int updateByExampleSelective(@Param("record") TForumSign record, @Param("example") TForumSignExample example);

    int updateByExample(@Param("record") TForumSign record, @Param("example") TForumSignExample example);
}