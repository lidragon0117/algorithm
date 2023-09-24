package com.lilong.代码随想录.贪心算法;

/**
 * @author :lilong
 * @date :2023-09-23-19:30
 * @description : 跳跃游戏
 */
public class CanJump {
    /**
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     * <p>
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * <p>
     * 判断你是否能够到达最后一个位置。
     * <p>
     * 示例  1:
     * <p>
     * 输入: [2,3,1,1,4]
     * 输出: true
     * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {

        //覆盖范围
        int conver = 0;
        for (int i = 0; i < conver; i++) {
            conver = Math.max(conver, i + nums[i]);
            if (conver >= nums.length-1) {
                return true;
            }
        }
        return false;
    }
}
