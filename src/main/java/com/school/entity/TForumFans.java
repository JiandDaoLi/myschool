package com.school.entity;

public class TForumFans {
    private Integer id;

    private Integer fkDecideUser;

    private Integer fkFansUser;

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "TForumFans{" +
                "id=" + id +
                ", fkDecideUser=" + fkDecideUser +
                ", fkFansUser=" + fkFansUser +
                '}';
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

    public Integer getFkFansUser() {
        return fkFansUser;
    }

    public void setFkFansUser(Integer fkFansUser) {
        this.fkFansUser = fkFansUser;
    }

}