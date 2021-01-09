package com.datastructure;

public interface Queue<E>{
    boolean isEmpty();
    int getSize();
    //队首元素
    E getFront();
    //入队列
    void enQueue(E e);
    //出队列
    E deQueue();
}
