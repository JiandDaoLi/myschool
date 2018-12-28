package com.school.service.impl;

/**
 * Created by Administrator on 2018/12/28.
 */
public interface ForumUserApplaudService {

    boolean selectMeWhetherApplaud(int userId, int articleId);

    boolean addApplaud(int userId, int articleId);

    boolean deleteApplaud(int userId, int articleId);
}
