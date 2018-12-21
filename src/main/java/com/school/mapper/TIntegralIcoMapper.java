package com.school.mapper;

import com.school.entity.TIntegralIco;
import com.school.entity.TIntegralIcoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TIntegralIcoMapper {
    long countByExample(TIntegralIcoExample example);

    int deleteByExample(TIntegralIcoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TIntegralIco record);

    int insertSelective(TIntegralIco record);

    List<TIntegralIco> selectByExample(TIntegralIcoExample example);

    TIntegralIco selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TIntegralIco record, @Param("example") TIntegralIcoExample example);

    int updateByExample(@Param("record") TIntegralIco record, @Param("example") TIntegralIcoExample example);

    int updateByPrimaryKeySelective(TIntegralIco record);

    int updateByPrimaryKey(TIntegralIco record);
}