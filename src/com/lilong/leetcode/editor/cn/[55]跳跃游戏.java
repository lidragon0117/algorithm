package com.lilong.leetcode.editor.cn;//给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
// 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 10⁵ 
// 
//
// Related Topics 贪心 数组 动态规划 👍 2458 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canJump(int[] nums) {
        //跳跃到的位置
        int mustLocation=0;
        for(int loc=0;loc<nums.length;loc++){
            //如果所在下标大于最远的跳跃位置就不能返回
            if(loc>mustLocation){
                return false;
            }
            //更新最远的位置=当前位置+该位置还能跳多远，与当前最远的跳跃哪个大
            mustLocation=Math.max(loc+nums[loc],mustLocation);
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
