package com.datastructure;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author heibai
 * @date 2021/1/11 20:56
 */
public class BST<E extends Comparable<E>> {
    private class Node{
        E e;
        public Node right,left;
        public Node(E e) {
            this.e = e;
            left=null;
            right=null;
        }
    }
    private Node root;
    private int size;
    public BST(){
        root=null;
        size=0;
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }

    /**
     * 向二分搜索树中添加新的元素e
     * @param e
     */
    public void add(E e){
        root = add(root,e);
    }

    /**
     * 向以node为根的二分搜索树中插入元素e，递归算法
     * @param node
     * @param e
     */
    private Node add(Node node, E e) {
        if (node==null){
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) >0){
            node.right=add(node.right,e);
        }
        else if (e.compareTo(node.e) <0)
            node.left=add(node.left ,e);
        return node;
    }
    //看二分搜索树中是否包含e
    public boolean contains(E e){
        return contains(root,e);
    }
    //以node为根的二分搜索树中是否包含元素e,递归算法
    private boolean contains(Node node, E e) {

        if (node==null)
            return false;
        if (node.e.compareTo(e) ==0 ){
            return true;
        }
        else if(e.compareTo(node.e) >0 ){
            return contains(node.right , e);
        }
        else
            return contains(node.left ,e );
    }

    public void preOrder(){
        preOrder(root);
    }
    //前序遍历
    private void preOrder(Node node) {
        if (node!=null){
            System.out.println(node.e);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 非递归实现前序遍历
     */
    public void preOrderNR(){
        Stack<Node> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null)
                stack.push(cur.right);

            if (cur.left != null)
                stack.push(cur.left);


        }
    }


    public void inOrder(){
        inOrder(root);
    }
    //中序遍历
    private void inOrder(Node node) {
        if (node!=null){
            inOrder(node.left);
            System.out.println(node.e);
            inOrder(node.right);
        }
    }
    public void postOrder(){
        postOrder(root);
    }
    //后序遍历
    private void postOrder(Node node) {
        if (node!=null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.e);
        }
    }

    /**
     * 层次遍历
     */
    public void levelOrder(){
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node cur=queue.remove();
            System.out.println(cur.e);
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
    }
    /**
     * 最小元素
     * @return
     */
    public E minimum(){
        if (size ==0)
            throw new IllegalArgumentException("BST is empty");
        return minimum(root).e;
    }
    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    /**
     * 最大元素
     * @return
     */
    public E maximum(){
        if (size ==0)
            throw new IllegalArgumentException("BST is empty");
        return maximum(root).e;
    }
    private Node maximum(Node node) {
        if (node.right == null)
            return node;
        return maximum(node.right);
    }

    /**
     * 删除最小元素节点
     * 返回删除的元素
     * @return
     */
    public E removeMin(){
        E ret=minimum();

        removeMin(root);
        return ret;
    }
    //删除掉以node为根的二分搜索树中的最小节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node) {
        if (node.left == null){
            Node rightNode=node.right;
            node.left=null;
            size--;
            return rightNode;
        }
        node.left= removeMin(node.left);
        return node;
    }

    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {

        if (node==null){
            res.append(generateDepthString(depth)+"null\n");
            return;
        }
        res.append(generateDepthString(depth)+node.e+"\n" );
        generateBSTString(node.left,depth+1,res);
        generateBSTString(node.right,depth+1,res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res=new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        BST<Integer> bst=new BST<>();
        Random random=new Random();
        int n=1000;
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(1000));
        }
        ArrayList<Integer> arrayList=new ArrayList<>();
        while (!bst.isEmpty()){
            arrayList.add(bst.removeMin());
        }
        System.out.println(arrayList);

    }
}
