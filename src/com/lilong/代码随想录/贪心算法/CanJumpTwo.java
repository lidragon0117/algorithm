package com.lilong.代码随想录.贪心算法;

/**
 * @author :lilong
 * @date :2023-09-23-19:48
 * @description : 跳跃问题
 */
public class CanJumpTwo {
    /**
     * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
     * <p>
     * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
     * <p>
     * 0 <= j <= nums[i]
     * i + j < n
     * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [2,3,1,1,4]
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。
     * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
     * 跳跃问题 II
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int maxArea = 0;
        int curArea = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            maxArea = Math.max(maxArea, i + nums[i]);
            if (maxArea >= nums.length - 1) {
                count++;
                break;
            }
            if (i == curArea) {
                curArea = maxArea;
                count++;
            }
        }
        return count;
    }
}
