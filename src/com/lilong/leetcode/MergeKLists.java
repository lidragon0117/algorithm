package com.lilong.leetcode;

/**
 * @author : lilong
 * @date : 2023-11-04 23:03
 * @description :
 */
public class MergeKLists {
    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     * 示例 1：
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 解释：链表数组如下：
     * [
     * 1->4->5,
     * 1->3->4,
     * 2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; i++) {
            ans = mergeKLists(ans, lists[i]);
        }
        return ans;

    }

    private ListNode mergeKLists(ListNode listOne, ListNode listTwo) {
        if (listOne == null || listTwo == null) {
            return listOne == null ? listTwo : listOne;
        }
        ListNode head = new ListNode(0);
        ListNode temp = head, left = listOne, right = listTwo;
        while (left != null && right != null) {
            if (left.val < right.val) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        temp.next = left == null ? right : left;
        return head.next;
    }
}
