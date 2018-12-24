package com.school.mapper;

import com.school.entity.TFkArticleUserApplaudStatus;
import com.school.entity.TFkArticleUserApplaudStatusExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TFkArticleUserApplaudStatusMapper {
    long countByExample(TFkArticleUserApplaudStatusExample example);

    int deleteByExample(TFkArticleUserApplaudStatusExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TFkArticleUserApplaudStatus record);

    int insertSelective(TFkArticleUserApplaudStatus record);

    List<TFkArticleUserApplaudStatus> selectByExample(TFkArticleUserApplaudStatusExample example);

    TFkArticleUserApplaudStatus selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TFkArticleUserApplaudStatus record, @Param("example") TFkArticleUserApplaudStatusExample example);

    int updateByExample(@Param("record") TFkArticleUserApplaudStatus record, @Param("example") TFkArticleUserApplaudStatusExample example);

    int updateByPrimaryKeySelective(TFkArticleUserApplaudStatus record);

    int updateByPrimaryKey(TFkArticleUserApplaudStatus record);
}