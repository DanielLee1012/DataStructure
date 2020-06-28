package com.selflearning.designmodel.singleton;

import java.io.Serializable;

/**
 * @ClassName: Seriable 枚举式
 * @Description:
 * @Author: DanielLee
 * @Date:2020/6/28 17:44
 * @Version: V1.0
 * 反序列化时导致单例破坏
 */
public class Seriable implements Serializable {

    //序列化就是把内存中的状态通过转换成字节码的形式
    //从而转化成一个IO流，写入其他地方（如磁盘，网络IO），内存中的状态给永久保存下来

    //反序列化是将已经持久化的字节码内容，转换成IO流，通过IO流的读取，将读取的内容转化为java对象，在转化的过程中会重新创建对象new

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
