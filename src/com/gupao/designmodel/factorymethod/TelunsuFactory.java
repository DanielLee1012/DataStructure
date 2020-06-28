package com.gupao.designmodel.factorymethod;

import com.gupao.designmodel.Milk;
import com.gupao.designmodel.Telunsu;
/**
 *TelunsuFactory
 *<p>Title: </p>
 *<p>Description:事情越来越专业</p>
 *@author DanielLee
 *@version V1.0
 *@date 2020/6/27 19:43
 */
public class TelunsuFactory implements Factory {

    @Override
    public Milk getMilk() {
        return new Telunsu();
    }
}
