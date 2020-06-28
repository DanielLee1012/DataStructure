package com.selflearning.designmodel.simplefactory;

import com.selflearning.designmodel.Mengniu;
import com.selflearning.designmodel.Milk;
import com.selflearning.designmodel.Telunsu;

public class SimpleFactory {

    public Milk getMilk(String name){

        if ("T".equals(name)){
            return new Telunsu();
        }
        else if("M".equals(name)){
            return new Mengniu();
        }
        return null;
    }

}
