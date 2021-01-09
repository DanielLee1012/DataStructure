package com.datastructure;

/**
 * @author heibai
 * @date 2021/1/9 14:38
 */
public class ArrayQueue<E> implements Queue<E> {
    private Array<E> array;
    public ArrayQueue(int capacity){
        array=new Array<>(capacity);
    }
    public ArrayQueue(){
        array=new Array<>();
    }
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public void enQueue(E e) {
        array.addLast(e);
    }

    @Override
    public E deQueue() {
        return array.removeFirst();
    }
    public int getCapacity(){
        return array.getCapacity();
    }
    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append("Queue:");
        res.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i!=array.getSize()-1)
                res.append(",");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue=new ArrayQueue<>();
        for (int i = 0; i <10 ; i++) {
            arrayQueue.enQueue(i);
            System.out.println(arrayQueue);
        }
        arrayQueue.deQueue();
        System.out.println(arrayQueue);
    }
}
