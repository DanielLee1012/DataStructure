package com.selflearning.designmodel.abstractfactory;

/**
 * <p>Title:DataStructure</p>
 * <p>Description:</p>
 *
 * @author DanielLee
 * @version V1.0
 * @date 2020/6/27 19:53
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        MilkFactory factory = new MilkFactory();

        //对于用户而言，更加简单了
        //用户只要选择的权力，保证了程序的健壮性
        System.out.println(factory.getMengniu());
    }
}
