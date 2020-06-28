package com.selflearning.designmodel.simplefactory;
/**
 *小作坊式的简单工厂模式
 */
public class SimpleTest {
    public static void main(String[] args) {
        //new的过程实际上是一个比较复杂的过程
        //System.out.println(new Telunsu().getName());


        //小作坊的生产模式
        //成分和配比都是不一样的
        SimpleFactory factory = new SimpleFactory();

        //把用户的需求告诉工厂
        //创建产品的过程隐藏了，对于用户完全不知道怎么产生的
        System.out.println(factory.getMilk("T"));
    }

}
