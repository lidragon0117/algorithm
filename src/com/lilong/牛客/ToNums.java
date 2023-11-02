package com.lilong.牛客;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : lilong
 * @date : 2023-11-02 16:26
 * @description : 两数之和
 */
public class ToNums {
    /**
     * 给出一个整型数组 numbers 和一个目标值 target，请在数组中找出两个加起来等于目标值的数的下标，返回的下标按升序排列。
     * （注：返回的数组下标从1开始算起，保证target一定可以由数组里面2个数字相加得到）
     *
     * @param numbers 数组
     * @param target  目标数
     * @return 返回数组
     */
    public int[] twoSum(int[] numbers, int target) {
        // write code here
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int temp = target - numbers[i];
            if (map.containsKey(temp)) {
                result[0] = map.get(temp);
                result[1] = i;
            }
            map.put(numbers[i], i+1);
        }
        return result;
    }
}
