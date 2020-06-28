package com.selflearning.designmodel.abstractfactory;

import com.selflearning.designmodel.Milk;

/**
 * <p>Title:DataStructure</p>
 * <p>Description:</p>
 * 抽象工厂是用户的主入口
 * 在spring中应用最为广泛的一种设计模式
 * 易于扩展
 * @author DanielLee
 * @version V1.0
 * @date 2020/6/27 19:49
 */
public abstract class AbstractFactory {

    /**
     *Title: 获得一个蒙牛品牌的产品
     *@return
     */
    public abstract Milk getTelunsu();

    public abstract Milk getMengniu();
}
