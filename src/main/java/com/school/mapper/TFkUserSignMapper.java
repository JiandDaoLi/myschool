package com.school.mapper;

import com.school.entity.TFkUserSign;
import com.school.entity.TFkUserSignExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TFkUserSignMapper {
    long countByExample(TFkUserSignExample example);

    int deleteByExample(TFkUserSignExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TFkUserSign record);

    int insertSelective(TFkUserSign record);

    List<TFkUserSign> selectByExample(TFkUserSignExample example);

    TFkUserSign selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TFkUserSign record, @Param("example") TFkUserSignExample example);

    int updateByExample(@Param("record") TFkUserSign record, @Param("example") TFkUserSignExample example);

    int updateByPrimaryKeySelective(TFkUserSign record);

    int updateByPrimaryKey(TFkUserSign record);
}