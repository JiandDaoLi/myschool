package com.school.mapper;

import com.school.entity.TForumArticle;
import com.school.entity.TForumArticleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TForumArticleMapper {
    long countByExample(TForumArticleExample example);

    int deleteByExample(TForumArticleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TForumArticle record);

    int insertSelective(TForumArticle record);

    List<TForumArticle> selectByExample(TForumArticleExample example);

    TForumArticle selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TForumArticle record, @Param("example") TForumArticleExample example);

    int updateByExample(@Param("record") TForumArticle record, @Param("example") TForumArticleExample example);

    int updateByPrimaryKeySelective(TForumArticle record);

    int updateByPrimaryKey(TForumArticle record);

    List<TForumArticle> selectLikeTitleNotIn(Map<String, Object> map);

    List<TForumArticle> selectLikeContentNotIn(Map<String, Object> map);

    Integer selectBrowseCount(int userId);

    List<TForumArticle> selectLimitArticle(int userId);
}