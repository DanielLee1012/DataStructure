package com.selflearning.designmodel.factorymethod;

import com.selflearning.designmodel.Mengniu;
import com.selflearning.designmodel.Milk;


public class MengniuFactory implements Factory {

    @Override
    public Milk getMilk() {
        return new Mengniu();
    }
}
