package com.gupao.designmodel.singleton;

/**
 * @ClassName: LazyThree
 * @Description:改进型3：保证线程安全，同时提高性能
 * @Author: DanielLee
 * @Date:2020/6/28 16:32
 * @Version: V1.0
 */
public class LazyThree {

    private static boolean initialized = false;

    //默认使用lazyThree的时候，会先初始化内部类
    //如果没有使用的话，内部类不加载

    //对默认构造方法 private LazyThree(){}进行优化，防止通过反射入侵

    private LazyThree(){
        synchronized (LazyThree.class){
            if(initialized == false){
                initialized = true;
            }else{
                throw new RuntimeException("单例已被侵犯");
            }
        }
    }

    public static final LazyThree getInstance(){
        return LazyHolder.LAZY;
    }

    private static class LazyHolder{
        private static final LazyThree LAZY = new LazyThree();

    }
}
