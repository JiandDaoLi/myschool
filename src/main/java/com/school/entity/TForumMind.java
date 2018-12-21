package com.school.entity;

public class TForumMind {
    private Integer id;

    private Integer fkDecideUser;

    private Integer fkMindUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFkDecideUser() {
        return fkDecideUser;
    }

    public void setFkDecideUser(Integer fkDecideUser) {
        this.fkDecideUser = fkDecideUser;
    }

    public Integer getFkMindUser() {
        return fkMindUser;
    }

    public void setFkMindUser(Integer fkMindUser) {
        this.fkMindUser = fkMindUser;
    }
}