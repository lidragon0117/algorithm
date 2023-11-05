package com.lilong.代码随想录.链表;


/**
 * @author : lilong
 * @date : 2023-11-04 22:06
 * @description : 移除链表
 */
public class RemoveElements {
    /**
     * 题意：删除链表中等于给定值 val 的所有节点。
     * <p>
     * 示例 1： 输入：head = [1,2,6,3,4,5,6], val = 6 输出：[1,2,3,4,5]
     * <p>
     * 示例 2： 输入：head = [], val = 1 输出：[]
     * <p>
     * 示例 3： 输入：head = [7,7,7,7], val = 7 输出：[]
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode node = head;
        while (node != null) {
            while (node.next != null && node.next.val == val) {
                node.next = node.next.next;
            }
            node = node.next;
        }
        return head;
    }
}
