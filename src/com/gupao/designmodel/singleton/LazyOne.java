package com.gupao.designmodel.singleton;

/**
 * @ClassName: lazy 懒汉式（线程不安全）
 * @Description:默认加载的时候不实例化，
 *              在需要用的时候才实例化（延时加载）
 * @Author: DanielLee
 * @Date:2020/6/28 16:09
 * @Version: V1.0
 */
public class LazyOne {
    private LazyOne(){}
    private static LazyOne lazy = null;

    public static LazyOne getInstance(){
        if (lazy == null){
            lazy = new LazyOne();
        }
        return lazy;
    }

}
