package com.datastructure;

public class Array<E> {
    private E[] data;
    private int size;
    /**
     * 有参构造
     */
    public Array(int capacity){
       data = (E[])new Object[capacity];
       size = 0;
    }

    /**
     * 无参构造
     */
    public Array(){
       this(10);
    }

    /**
     * @return 获取数组元素个数
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取数组容量
     */
    public int getCapacity(){
        return data.length;
    }
    // 设置
    void set(int index,E e){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("set failed,index is illegal");
        data[index] = e;
    }

    // 获取
    E get(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("get failed,index is illegal");
        return data[index];
    }

    // 判断数组是否为空
    public boolean isEmpty(){
        return size ==0;
    }

    // 在数组最后添加元素
    public void addLast(E e){
        /*if (size == data.length)
            throw new IllegalArgumentException("AddLast failed,Array is full");
        data[size-1] = e;
        size++;*/
        addIndex(size,e);
    }

    // 在数组头部添加元素
    public void addFirst(E e){
        addIndex(0,e);
    }

    // 在数组指定位置添加元素
    public void addIndex(int index, E e){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("AddIndex failed,index < 0 or index>=size");
        if (size == data.length)
            resize(2*data.length);
        for (int i = size-1; i >= index; i--){
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    private void resize(int i) {
        E[] newdata = (E[])new Object[i];
        for (int j = 0; j < size; j++) {
            newdata[j] = data[j];
        }
        data = newdata;
    }

    //查找数组中是否包含元素e
    public  boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    //查找数组中元素e的索引，不存在则返回-1
    public  int find(E e){
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    //删除指定位置的元素e,并返回删除的元素
    public E remove(int index){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Remove failed,index < 0 or index>=size");
        E res  = data[index];
        for (int i = index + 1; i < size; i++){
            data[i - 1] = data[i];
        }
        size--;
        return res;
    }

    //删除数组中的第一个元素e
    public E removeLast(){
        return remove(size-1);
    }

    //删除数组中的最后一个元素e
    public E removeFirst(){
        return remove(0);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("array.size %d ,capacity is %d \n",size,data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }


}
