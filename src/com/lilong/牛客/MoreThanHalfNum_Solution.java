package com.lilong.牛客;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : lilong
 * @date : 2023-11-02 19:48
 * @description :
 */
public class MoreThanHalfNum_Solution {
    /**
     * 给一个长度为 n 的数组，数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * 例如输入一个长度为9的数组[1,2,3,2,2,2,5,4,2]。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
     *
     * @param numbers
     * @return
     */
    public int MoreThanHalfNum_Solution(int[] numbers) {
        // write code here
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                map.put(numbers[i], map.getOrDefault(numbers[i], 1) + 1);
            } else {
                map.put(numbers[i], 1);
            }
            if (map.get(numbers[i]) > numbers.length / 2) {
                return numbers[i];
            }
        }
        return 0;
    }
}
