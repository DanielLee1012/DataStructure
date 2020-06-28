package com.selflearning.designmodel.singleton;

/**
 * @ClassName: lazyTwo 改进型，懒汉式增加同步锁后线程安全,但性能很差
 * @Description:默认加载的时候不实例化，
 *              在需要用的时候才实例化（延时加载）
 * @Author: DanielLee
 * @Date:2020/6/28 16:09
 * @Version: V1.0
 */
public class LazyTwo {
    private LazyTwo(){}
    private static LazyTwo lazy = null;
    /**
     *Title: 懒汉式单例：加共享锁，保证了线程安全，但降低了性能
     *@description
     *@author DanielLee
     *@date 2020/6/28 21:37
     *@param null
     *@return
     */
    public static synchronized  LazyTwo getInstance(){
        if (lazy == null){
            lazy = new LazyTwo();
        }
        return lazy;
    }

}
