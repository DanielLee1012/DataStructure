package com.gupao.designmodel.singleton;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: Map
 * @Description:注册登记式：每使用一次，都往一个固定的容器中注册并且将使用过的对象进行缓存，
 * 下次取对象的时候，就直接从缓存中取值，以保证每次获取的都是同一个目标
 * IOC中的单例模式，就是典型的注册登记式单例
 * @Author: DanielLee
 * @Date:2020/6/28 17:21
 * @Version: V1.0
 */
public class RegisterMap {
    private static Map<String,Object> register = new ConcurrentHashMap<String,Object>();

    public static RegisterMap getInstance(String name){
        if (name == null){
            name = RegisterMap.class.getName();
        }
        if(register.get(name)==null){
            try {
                register.put(name,new RegisterMap());
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return (RegisterMap)register.get(name);
    }
}
