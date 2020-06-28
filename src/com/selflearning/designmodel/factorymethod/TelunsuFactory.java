package com.selflearning.designmodel.factorymethod;

import com.selflearning.designmodel.Milk;
import com.selflearning.designmodel.Telunsu;

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
