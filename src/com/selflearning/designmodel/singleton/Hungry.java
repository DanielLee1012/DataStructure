package com.selflearning.designmodel.singleton;

/**
 * @ClassName: Hungry 饿汉式（线程安全）
 * @Description:在实例使用之前，不管你用不用，
 *              我先new出来，避免了线程安全问题
 * @Author: DanielLee
 * @Date:2020/6/28 15:35
 * @Version: V1.0
 *
 * 饿汉式单例：在类加载的时候就立即初始化，并且创建单例对象
 *    优点：没有加任何的锁，执行效率高，字用户体验上比懒汉更好，绝对线程安全的
 *    缺点：类加载时就创建，不管使用与否，都占用空间，浪费内存，
 */
public class Hungry {
    private Hungry(){}

    //先静态后动态
    //先属性后方法
    //先上后下
    private  static final Hungry hungry = new Hungry();
    public static Hungry getInstance(){
        System.out.println(System.currentTimeMillis()+":"+hungry);
        return hungry;
    }
}
