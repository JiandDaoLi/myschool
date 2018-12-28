package com.school.service;

/**
 * Created by Administrator on 2018/12/28.
 */
public interface ForumUserSignService {

    boolean selectMeWhetherSign(int userId, int articleId);

    boolean deleteSign(int userId, int articleId);

    boolean addSign(int userId, int articleId);
}
