package com.school;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Auther: XiTao
 * @Date: 2018/12/22
 * @Field:
 */
public class d {
    private static String ss = new String();
    static ReadWriteLock rwl = new ReentrantReadWriteLock();
    public static void g(String s){
        ss = s;
        System.out.println(Thread.currentThread().getName()+"_存入_"+ss);

    }

    public static void s(String s){
        System.out.println(Thread.currentThread().getName()+"_获取_"+ss);
    }


    public static void main(String[] args) {
        List<Integer> l = new ArrayList();
        l.add(1);
        final Integer[] c = {1};
        l.forEach( lu -> {
            c[0] = c[0] + lu;
        });
        System.out.println(c[0]);

    }
}
