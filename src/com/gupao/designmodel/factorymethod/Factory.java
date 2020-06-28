package com.gupao.designmodel.factorymethod;

import com.gupao.designmodel.Milk;

public interface Factory {
    //工厂必然具有生产产品技能，统一的产品出口
    Milk getMilk();
}
