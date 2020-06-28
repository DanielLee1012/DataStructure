package com.selflearning.designmodel.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName: ThreadSafeTest
 * @Description:
 * @Author: DanielLee
 * @Date:2020/6/28 15:44
 * @Version: V1.0
 */
public class ThreadSafeTest {
    public static void main(String[] args) {
        int count = 200;
        CountDownLatch latch = new CountDownLatch(count);

        for (int i = 0; i < count; i++) {
            new Thread(){
                @Override
                public void run(){
                  /*  Hungry.getInstance();
                    try{
                    // 线程阻塞，等count = 0 时释放共享锁，才开始执行后边的内容，多个线程同时执行
                        latch.await();
                    }catch (Exception e){
                        e.printStackTrace();
                    }*/

                    try{
                        // 线程阻塞，等count = 0 时才开始执行后边的内容，多个线程同时执行
                        latch.await();
                        //懒汉式，线程不安全
                        //Object obj = LazyOne.getInstance();

                        //改进型，懒汉式增加同步锁后线程安全,但性能很差
                        //Object obj = LazyTwo.getInstance();

                        //改进型3,线程安全,性能
                        Object obj3 = LazyThree.getInstance();
                        System.out.println(System.currentTimeMillis()+":"+obj3);

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }.start();
            latch.countDown();
        }
    }
}
