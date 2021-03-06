package com.datastructure;
/**
 * @author heibai
 * @date 2021/1/9 15:03
 */
public class LoopQueue<E> implements Queue<E>{
    private E[] data;
    private int front,tail;
    private int size;
    public LoopQueue(int capacity){
        data= (E[]) new Object[capacity+1];
        front=0;
        tail=0;
        size=0;
    }
    public LoopQueue(){
        this(10);
    }
    public int getCapacity(){
        return data.length-1;
    }
    @Override
    public boolean isEmpty() {
        return front==tail;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is Empty");

        return data[front];
    }

    @Override
    public void enQueue(E e) {
        //判断队列是否满
        if ((tail+1)%data.length==front)
            resize(getCapacity()*2);
        data[tail]=e;
        tail=(tail+1)%data.length;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData= (E[]) new Object[newCapacity+1];
        for (int i = 0; i <size ; i++) {
            newData[i]=data[(i+front)%data.length];
        }
        data=newData;
        front=0;
        tail=size;
    }

    @Override
    public E deQueue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        E res=data[front];
        data[front]=null;
        front=(front+1)%data.length;
        size--;
        if (size==getCapacity()/4 &&getCapacity() /2!=0){
            resize(getCapacity()/2);
        }
        return res;
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue.size %d ,capacity is %d \n",size,getCapacity()));
        res.append("front [");
        for (int i = front; i !=tail; i=(i+1)%data.length) {
            res.append(data[i]);
            if ((i+1)%data.length != tail) {
                res.append(",");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue=new LoopQueue<>();
        for (int i = 0; i <10 ; i++) {
            queue.enQueue(i);
            System.out.println(queue);
        }

        queue.enQueue(21);
        for (int i = 0; i <10 ; i++) {

            queue.deQueue();
        }
        System.out.println(queue);
    }
}
