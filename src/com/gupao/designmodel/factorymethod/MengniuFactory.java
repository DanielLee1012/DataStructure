package com.gupao.designmodel.factorymethod;

import com.gupao.designmodel.Mengniu;
import com.gupao.designmodel.Milk;


public class MengniuFactory implements Factory {

    @Override
    public Milk getMilk() {
        return new Mengniu();
    }
}
