package com.school.mapper;

import com.school.entity.TForumFans;
import com.school.entity.TForumFansExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TForumFansMapper {
    long countByExample(TForumFansExample example);

    int deleteByExample(TForumFansExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TForumFans record);

    int insertSelective(TForumFans record);

    List<TForumFans> selectByExample(TForumFansExample example);

    TForumFans selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TForumFans record, @Param("example") TForumFansExample example);

    int updateByExample(@Param("record") TForumFans record, @Param("example") TForumFansExample example);

    int updateByPrimaryKeySelective(TForumFans record);

    int updateByPrimaryKey(TForumFans record);
}