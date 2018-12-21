package com.school.entity;

public class TFkUserSign {
    private Integer id;

    private Integer fkUserKey;

    private Integer fkSignKey;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFkUserKey() {
        return fkUserKey;
    }

    public void setFkUserKey(Integer fkUserKey) {
        this.fkUserKey = fkUserKey;
    }

    public Integer getFkSignKey() {
        return fkSignKey;
    }

    public void setFkSignKey(Integer fkSignKey) {
        this.fkSignKey = fkSignKey;
    }
}