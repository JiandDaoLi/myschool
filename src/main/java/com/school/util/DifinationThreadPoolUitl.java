package com.school.util;

import org.apache.ibatis.executor.ExecutorException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: XiTao
 * @Date: 2018/12/22
 * @Field: 线程池
 */
public class DifinationThreadPoolUitl {
    private static ExecutorService executorException = Executors.newCachedThreadPool();


    public  static DifinationThreadPoolUitl getTheraPoolCacheAutoLength(){
        executorException.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        return new DifinationThreadPoolUitl();
    }

    public static void main(String[] args) {
        getTheraPoolCacheAutoLength();
    }

}
