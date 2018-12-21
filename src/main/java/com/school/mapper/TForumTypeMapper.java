package com.school.mapper;

import com.school.entity.TForumType;
import com.school.entity.TForumTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TForumTypeMapper {
    long countByExample(TForumTypeExample example);

    int deleteByExample(TForumTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TForumType record);

    int insertSelective(TForumType record);

    List<TForumType> selectByExample(TForumTypeExample example);

    TForumType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TForumType record, @Param("example") TForumTypeExample example);

    int updateByExample(@Param("record") TForumType record, @Param("example") TForumTypeExample example);

    int updateByPrimaryKeySelective(TForumType record);

    int updateByPrimaryKey(TForumType record);
}