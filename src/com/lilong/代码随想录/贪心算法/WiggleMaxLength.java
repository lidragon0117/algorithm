package com.lilong.代码随想录.贪心算法;

/**
 * @author :lilong
 * @date :2023-09-23-15:01
 * @description : 最大摆动序列
 */
public class WiggleMaxLength {
    /**
     * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
     * <p>
     * 例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3)  是正负交替出现的。相反, [1,4,7,2,5]  和  [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
     * <p>
     * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,7,4,9,2,5]
     * 输出: 6
     * 解释: 整个序列均为摆动序列
     */
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) {
            return nums.length;
        }
        int preDiff = 0;
        int curDiff = 0;
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            curDiff = nums[i] - nums[i - 1];
            if ((curDiff < 0 && preDiff >= 0) || (curDiff > 0 && preDiff <= 0)) {
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }
}
