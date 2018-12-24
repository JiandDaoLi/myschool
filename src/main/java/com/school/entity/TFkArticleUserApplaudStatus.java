package com.school.entity;

public class TFkArticleUserApplaudStatus {
    private Integer id;

    private Integer fkArticleKey;

    private Integer fkUserKey;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFkArticleKey() {
        return fkArticleKey;
    }

    public void setFkArticleKey(Integer fkArticleKey) {
        this.fkArticleKey = fkArticleKey;
    }

    public Integer getFkUserKey() {
        return fkUserKey;
    }

    public void setFkUserKey(Integer fkUserKey) {
        this.fkUserKey = fkUserKey;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}