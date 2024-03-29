package com.lilong.代码随想录.动态规划;

/**
 * @author :lilong
 * @date :2023-09-28-1:08
 * @description :
 */
public class RobTwo {
    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
     * 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
     * 示例 1：
     * 输入：nums = [2,3,2]
     * 输出：3
     * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        return Math.max(rob(nums,0,nums.length-1),rob(nums,1,nums.length));
    }
    public static int rob(int[] nums,int start,int end){
        int x= 0,y=0,z=0;
        for (int i=start;i<end;i++){
            y=z;
            z=Math.max(y,x+nums[i]);
            x=y;
        }
        return z;
    }
}
