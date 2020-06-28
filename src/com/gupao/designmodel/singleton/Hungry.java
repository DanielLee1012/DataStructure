package com.gupao.designmodel.singleton;

import java.security.PublicKey;

/**
 * @ClassName: Hungry 饿汉式（线程安全）
 * @Description:在实例使用之前，不管你用不用，
 *              我先new出来，避免了线程安全问题
 * @Author: DanielLee
 * @Date:2020/6/28 15:35
 * @Version: V1.0
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
