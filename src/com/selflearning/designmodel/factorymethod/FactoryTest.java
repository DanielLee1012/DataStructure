package com.selflearning.designmodel.factorymethod;

public class FactoryTest {
    public static void main(String[] args) {

        //货比三家，不知道谁好谁坏
        //配置，可能会配置错
        //Factory factory = new MengniuFactory();
        Factory factory = new TelunsuFactory();
        factory.getMilk();

    }
}
