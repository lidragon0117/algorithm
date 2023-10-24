package com.lilong.牛客;

/**
 * @author :lilong
 * @date :2023-10-06-21:19
 * @description :
 */
public class Merge {
    public ListNode Merge(ListNode pHead1, ListNode pHead2) {
        if (pHead1 != null && pHead2 != null) {
            return null;
        }
        ListNode node = new ListNode(-1);
        ListNode temp = node;
        while (pHead1 != null && pHead2 != null) {
            if (pHead1.val < pHead2.val) {
                temp.next = pHead1;
                pHead1 = pHead1.next;
            } else {
                temp.next = pHead2;
                pHead2 = pHead2.next;
            }
        }
        temp.next = pHead1 == null ? pHead2 : pHead1;
        return node.next;
    }
}
