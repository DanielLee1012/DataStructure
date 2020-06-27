package com.datastructure;

public class LinkedList<E> {

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

    private Node head;
    private int size;

    public LinkedList(){
        head = null;
        size = 0;
    }

    public int getSize(){return size;}

    public boolean isEmpty(){return size == 0;}

    public void add(E e,int index){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed,Illegal index.");
        if (index == 0) {
            head = new Node(e,head.next);
        }
        for (int i = 0; i < index -1; i++)
            head = head.next;

        Node node = new Node(e);
        node.next = head.next;
        head.next = node;


        size ++;
    }


}
