package com.selflearning.designmodel.abstractfactory;

import com.selflearning.designmodel.factorymethod.MengniuFactory;
import com.selflearning.designmodel.factorymethod.TelunsuFactory;
import com.selflearning.designmodel.Milk;

/**
 * <p>Title:DataStructure</p>
 * <p>Description:</p>
 *
 * @author DanielLee
 * @version V1.0
 * @date 2020/6/27 19:55
 */
public class MilkFactory extends AbstractFactory {
    @Override
    public Milk getTelunsu() {
        return new TelunsuFactory().getMilk();
        //return new Telunsu();
    }

    @Override
    public Milk getMengniu() {
        return new MengniuFactory().getMilk();
        //return new Mengniu();
    }
}
