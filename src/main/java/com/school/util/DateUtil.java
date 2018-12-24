package com.school.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: XiTao
 * @Date: 2018/12/23
 * @Field:时间处理
 */
public class DateUtil {

    /**
     * 获取时间String
     * @param date
     * @return
     */
    public static String getDate(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd hh:mm:ss");
        String h = simpleDateFormat.format(date);
        System.out.println(h);
        return h;
    }

    /**
     * 获取时间date
     * @param s
     * @return
     */
    public static Date getDate(String s){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd hh:mm:ss");
        Date date = null;
        try {
            date = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }



}
