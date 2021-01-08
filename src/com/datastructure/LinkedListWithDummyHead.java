package com.datastructure;

/**
 * 带有虚拟头结点的链表
 * @param <E>
 */
public class LinkedListWithDummyHead<E> {

    private class Node{
        public E e;
        public Node next;

        public Node (E e,Node next){
            this.e = e;
            this.next = next;
        }
        public Node (E e){this(e,null); }
        public Node(){this(null,null); }

        @Override
        public  String toString(){return e.toString(); }
    }

    private Node dummyhead;
    private int size;

    public LinkedListWithDummyHead(){
        dummyhead = new Node(null,null);
        size = 0;
    }

    public int getSize(){return size;}

    public boolean isEmpty(){return size == 0;}

    public void add(E e,int index){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed,Illegal index.");
        Node pre = dummyhead;
        //从dummyhead开始遍历，所以是index，虚拟头结点dummyhead指向了head
        for (int i = 0; i < index; i++)
            pre = pre.next;

        pre.next = new Node(e,pre.next);
        size ++;
    }


}
