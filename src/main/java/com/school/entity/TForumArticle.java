package com.school.entity;

import java.util.Date;

public class TForumArticle {
    private Integer id;

    private String title;

    private Integer fkForumTypeKey;

    private String contentText;

    private Date createTime;

    private Integer fkUserKey;

    private Integer violationCount;

    private Integer fkApplaudStatus;

    private Integer browseConut;

    private Integer commentCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getFkForumTypeKey() {
        return fkForumTypeKey;
    }

    public void setFkForumTypeKey(Integer fkForumTypeKey) {
        this.fkForumTypeKey = fkForumTypeKey;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText == null ? null : contentText.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getFkUserKey() {
        return fkUserKey;
    }

    public void setFkUserKey(Integer fkUserKey) {
        this.fkUserKey = fkUserKey;
    }

    public Integer getViolationCount() {
        return violationCount;
    }

    public void setViolationCount(Integer violationCount) {
        this.violationCount = violationCount;
    }

    public Integer getFkApplaudStatus() {
        return fkApplaudStatus;
    }

    public void setFkApplaudStatus(Integer fkApplaudStatus) {
        this.fkApplaudStatus = fkApplaudStatus;
    }

    public Integer getBrowseConut() {
        return browseConut;
    }

    public void setBrowseConut(Integer browseConut) {
        this.browseConut = browseConut;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    @Override
    public String toString() {
        return "TForumArticle{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", fkForumTypeKey=" + fkForumTypeKey +
                ", contentText='" + contentText + '\'' +
                ", createTime=" + createTime +
                ", fkUserKey=" + fkUserKey +
                ", violationCount=" + violationCount +
                ", fkApplaudStatus=" + fkApplaudStatus +
                ", browseConut=" + browseConut +
                ", commentCount=" + commentCount +
                '}';
    }
}