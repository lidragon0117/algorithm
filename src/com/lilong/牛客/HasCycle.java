package com.lilong.牛客;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author :lilong
 * @date :2023-10-06-21:35
 * @description : 判断是否有环
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        List<Integer> list=new ArrayList<>();
        Integer[] objects = (Integer[]) list.toArray();
        if (head == null) return false;
        ListNode left = head;
        ListNode right = head.next;
        while (left != right) {
            if (right.next == null || right == null) return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }
}
