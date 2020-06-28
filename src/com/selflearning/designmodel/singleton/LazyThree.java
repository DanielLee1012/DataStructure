package com.selflearning.designmodel.singleton;

/**
 * @ClassName: LazyThree
 * @Description:改进型3：保证线程安全，同时提高性能
 * @Author: DanielLee
 * @Date:2020/6/28 16:32
 * @Version: V1.0
 * 懒汉式单例
 *    特点：在外部类被调用时内部类才会被调用，完美低屏蔽了
 *
 */
public class LazyThree {

    private static boolean initialized = false;

    //默认使用lazyThree的时候，会先初始化内部类
    //如果没有使用的话，内部类不加载
    //巧妙的避免了线程安全的问题，
    // 兼顾了饿汉模式的内存浪费，也兼顾了synchronized性能问题
    // 最牛逼的单例模式的实现方法



    private LazyThree(){
        //对默认构造方法 private LazyThree(){}进行优化，防止通过反射入侵
        synchronized (LazyThree.class){
            if(initialized == false){
                initialized = true;
            }else{
                throw new RuntimeException("单例已被侵犯");
            }
        }
    }

    //每个关键字都不是多余的
    //static是为了使用单例的共享空间，final保证这个方法不会被重写或重载
    public static final LazyThree getInstance(){
        //在返回结果之前，一定会先加载内部类
        return LazyHolder.LAZY;
    }

    //内部类
    private static class LazyHolder{
        private static final LazyThree LAZY = new LazyThree();

    }
}
