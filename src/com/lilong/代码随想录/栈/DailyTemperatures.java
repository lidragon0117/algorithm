package com.lilong.代码随想录.栈;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author :lilong
 * @date :2023-09-23-10:53
 * @description : 栈 每日温度
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        new DailyTemperatures().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }

    /**
     * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
     * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
     * 输入: temperatures = [73,74,75,71,69,72,76,73]
     * 输出: [1,1,4,2,1,1,0,0]
     *
     * @param temperatures 数组
     * @return 数组
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.getLast()]) {
                Integer integer = stack.removeLast();
                res[integer] = i - integer;

            }
            stack.add(i);
        }
        return res;
    }
}
