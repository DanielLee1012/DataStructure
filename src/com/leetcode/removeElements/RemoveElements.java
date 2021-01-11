package com.leetcode.removeElements;

/**
 * 删除链表中等于给定值val的所有元素
 * @author heibai
 * @date 2021/1/11 13:46
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head,int val){

        /*
        while (head!=null && head.val==val){
            ListNode deNode=head;
            head=head.next;
            deNode.next=null;
        }
        if(head==null){
            return null;
        }
        ListNode prev=head;
        while(prev.next!=null){
            if (prev.next.val==val){
                ListNode deNode=prev.next;
                prev.next=deNode.next;
                deNode.next=null;
            }
            else
                prev = prev.next;
        }

        return head;
         */

        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        ListNode prev = dummyHead;
        while (prev.next!=null){
            if (prev.next.val==val){
                prev.next=prev.next.next;
            }
            else
                prev=prev.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr={1,2,6,3,4,5,6};
        ListNode head=new ListNode(arr);
        System.out.println(head);
        RemoveElements removeElements=new RemoveElements();
        ListNode res=removeElements.removeElements(head,6);
        System.out.println(res);
    }
}
