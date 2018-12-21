package com.school.entity;

public class TCommentReply {
    private Integer id;

    private Integer fkForumCommentKey;

    private String contentText;

    private Integer fkUserKey;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFkForumCommentKey() {
        return fkForumCommentKey;
    }

    public void setFkForumCommentKey(Integer fkForumCommentKey) {
        this.fkForumCommentKey = fkForumCommentKey;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText == null ? null : contentText.trim();
    }

    public Integer getFkUserKey() {
        return fkUserKey;
    }

    public void setFkUserKey(Integer fkUserKey) {
        this.fkUserKey = fkUserKey;
    }
}