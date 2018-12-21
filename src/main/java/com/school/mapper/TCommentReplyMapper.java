package com.school.mapper;

import com.school.entity.TCommentReply;
import com.school.entity.TCommentReplyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TCommentReplyMapper {
    long countByExample(TCommentReplyExample example);

    int deleteByExample(TCommentReplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCommentReply record);

    int insertSelective(TCommentReply record);

    List<TCommentReply> selectByExample(TCommentReplyExample example);

    TCommentReply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TCommentReply record, @Param("example") TCommentReplyExample example);

    int updateByExample(@Param("record") TCommentReply record, @Param("example") TCommentReplyExample example);

    int updateByPrimaryKeySelective(TCommentReply record);

    int updateByPrimaryKey(TCommentReply record);
}