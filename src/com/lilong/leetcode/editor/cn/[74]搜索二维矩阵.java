package com.lilong.leetcode.editor.cn;//给你一个满足下述两条属性的 m x n 整数矩阵：
//
// 
// 每行中的整数从左到右按非递减顺序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 矩阵 👍 821 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //使用二分查找
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                list.add(matrix[i][j]);
            }
        }
        int left=0;
        int right=list.size()-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(target< list.get(mid)){
                right=mid-1;
            }else if(target>list.get(mid)){
                left=mid+1;
            } else if(target==list.get(mid)){
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
