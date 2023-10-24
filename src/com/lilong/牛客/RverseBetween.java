package com.lilong.牛客;

import java.util.Stack;

/**
 * @author :lilong
 * @date :2023-10-06-17:03
 * @description :
 */
public class RverseBetween {
    /**
     * 在局域范围内反转链表
     * 将一个节点数为 size 链表 m 位置到 n 位置之间的区间反转，要求时间复杂度O(n)，空间复杂度O(1)。
     * {1,2,3,4,5},2,4
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode node = new ListNode(-1);
        node.next=head;
        ListNode pre=node;
        for(int i=0;i<m-1;i++){
            pre=pre.next;
        }
        ListNode cur = pre;
        for(int i=0;i<n-m+1;i++){
            cur = cur.next;
        }
        ListNode leftNode =pre.next;
        ListNode rightNode = cur.next;
        //切断
        pre.next=null;
        rightNode.next=null;
        //进行反转
        reverseListNode(leftNode);
        pre.next=rightNode;
        leftNode.next=cur;
        return node.next;
    }

    private void reverseListNode(ListNode head) {
        ListNode pre=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode temp = cur.next;
            cur.next=pre;
            pre=cur;
        }
    }
}



