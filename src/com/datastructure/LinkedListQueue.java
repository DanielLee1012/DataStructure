package com.datastructure;

/**
 * @author heibai
 * @date 2021/1/9 21:02
 */
public class LinkedListQueue<E> implements Queue<E>{

    private class Node{
        public E e;
        public Node next;

        public Node() {
        }
        public Node(E e,Node next){
            this.e=e;
            this.next=next;
        }
        public Node(E e){
            this.e=e;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
    private Node head,tail;
    private int size;
    public LinkedListQueue(){
        head=null;
        tail=null;
        size=0;
    }
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public E getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("Queue is empty");
        return head.e;
    }

    @Override
    public void enQueue(E e) {
        if (tail==null){
            tail =new Node(e);
            head=tail;
        }
        else {
            tail.next = new Node(e);
            tail=tail.next;
        }
        size++;
    }

    @Override
    public E deQueue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot deQueue from an empty queue");
        //删除头元素
        Node retNode=head;
        head=head.next;
        retNode.next=null;
        //如果head为空，tail 也为空
        if (head==null)
            tail=null;
        size--;
        return retNode.e;
    }
    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append("Queue : front ");
        Node cur = head;
        while (cur!=null){
            res.append(cur+"->");
            cur=cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }
    public static void main(String[] args) {
        LinkedListQueue<Integer> queue=new LinkedListQueue<>();
        for (int i = 0; i <10 ; i++) {
            queue.enQueue(i);
            System.out.println(queue);
        }
        queue.deQueue();
        System.out.println(queue);
    }
}
