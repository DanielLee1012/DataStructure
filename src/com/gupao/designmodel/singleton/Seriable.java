package com.gupao.designmodel.singleton;

import java.io.Serializable;

/**
 * @ClassName: Seriable 枚举式
 * @Description:
 * @Author: DanielLee
 * @Date:2020/6/28 17:44
 * @Version: V1.0
 */
public class Seriable implements Serializable {

    public final static Seriable INSTANCE = new Seriable();
    private Seriable(){}

    public static Seriable getInstance(){
        return INSTANCE;
    }

    //重写readResolve()，JVM调用，保证序列化和反序列化时线程安全
    private Object readResolve(){
        return INSTANCE;
    }
}
