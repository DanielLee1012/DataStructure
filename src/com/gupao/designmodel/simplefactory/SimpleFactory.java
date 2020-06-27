package com.gupao.designmodel.simplefactory;

import com.gupao.designmodel.Mengniu;
import com.gupao.designmodel.Milk;
import com.gupao.designmodel.Telunsu;

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
