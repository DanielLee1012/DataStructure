package com.datastructure;

public interface Stack<E> {
    void push(E e);//入栈
    E pop();//出栈
    E peek();//获取栈顶元素
    int getSize();//获取栈的数字个数
    boolean isEmpty();
    int getCapacity();//获取栈的容量
}
