package com.lilong.utils;

import javax.swing.tree.TreeNode;
import java.util.*;

import static jdk.nashorn.internal.objects.NativeString.search;

/**
 * @author :lilong
 * @date :2023-09-07-17:05
 * @description : leetCode 热题100
 */
public class LeetCodeUtils {
    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     *
     * @param nums   数组
     * @param target 结果
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                result[0] = i;
                result[1] = map.get(temp);
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    /**
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     *
     * @param nums 数组
     * @return 返回最大连续长度
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int size = 1;
                while (set.contains(num + 1)) {
                    size += 1;
                    num += 1;
                }
                max = max > size ? max : size;
            }
        }
        return max;
    }

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * @param nums 数组
     */
    public void moveZeroes(int[] nums) {
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[left++] = nums[i];
            }
        }
        //将其余的都变成0
        for (int i = left; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     *
     * @param height 高度
     * @return 返回最大值
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left <= right) {
            maxArea = height[left] < height[right] ? Math.max(maxArea, (right - left) * height[left++]) : Math.max(maxArea, (right - left) * height[right--]);

        }
        return maxArea;
    }

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * @param s 字符串长度
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int left = -1;
        Set<Character> set = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (left + 1 < s.length() && !set.contains(s.charAt(left + 1))) {
                set.add(s.charAt(left + 1));
                left++;
            }
            ans = Math.max(ans, left - i + 1);
        }
        return ans;
    }

    /**
     * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
     *
     * @param s 字符串
     * @param p 字符串
     * @return 返回列表的位置
     */
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        //
        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < p.length(); i++) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }
        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }
        for (int i = 0; i < s.length() - p.length(); ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + p.length()) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
     *
     * @param nums 数组
     * @param k    K的值
     * @return
     */
    public int subarraySum(int[] nums, int k) {

        return 0;
    }

    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     *
     * @param nums 数组
     * @return 返回数组最大和
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int maxSub = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxSub = Math.max(maxSub, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSub;
    }

    /**
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，
     * 并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     *
     * @param intervals 二维数组
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }
        List<int[]> result = new ArrayList<>();
        //排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] cur = intervals[0];
        for (int i = 0; i < intervals.length; i++) {
            if (cur[1] >= intervals[i][0]) {
                //判断是否大于
                cur[1] = Math.max(cur[1], intervals[i][1]);
            } else {
                result.add(cur);
                cur = intervals[i];
            }
        }
        result.add(cur);
        return result.toArray(new int[result.size()][2]);
    }

    /**
     * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
     *
     * @param nums 数组
     * @param k    值
     */
    public void rotate(int[] nums, int k) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[(i + k) % res.length] = nums[i];
        }
        for (int i = 0; i < res.length; i++) {
            nums[i] = res[i];
        }
    }

    /**
     * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
     *
     * @param nums 数组
     * @return 返回除自己以外其他数的积
     */
    public int[] productExceptSelf(int[] nums) {
        //这一题就是去除i 的值，只要计算i左边的值和右边的值的积，再计算左边和右边的积
        int[] answer = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        //计算左边的值的积
        left[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        //计算右边的值
        right[right.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        //计算所有的值
        for (int i = 0; i < answer.length; i++) {
            answer[i] = left[i] * right[i];
        }
        return answer;
    }

    /**
     * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
     * 将标记置零
     *
     * @param matrix 二维数组
     */
    public void setZeroes(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    col[j] = true;
                    row[i] = true;
                }
            }
        }
        //进行遍历
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 螺旋遍历
     *
     * @param matrix 二维数组
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0, right = col - 1;
        int top = 0, bottom = row - 1;
        while (left <= right && top <= bottom) {
            //先遍历上面
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            //遍历右边
            for (int i = top + 1; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            if (left < right && top < bottom) {
                for (int i = right - 1; i > left; i--) {
                    list.add(matrix[bottom][i]);
                }
                for (int i = bottom; i > top; i--) {
                    list.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return list;
    }

    /**
     * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
     * <p>
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            int index = searchTarget(row, target);
            if (index > 0) {
                return true;
            }
        }
        return false;
    }

    private int searchTarget(int[] row, int target) {
        int left = 0;
        int right = row.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (row[mid] > target) {
                right = mid - 1;
            } else if (row[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0, lenB = 0;
        while (curA != null) {
            curA = curA.next;
            lenA++;
        }
        while (curB != null) {
            curB = curB.next;
            lenB++;
        }
        curA = headA;
        curB = headB;
        if (lenA > lenB) {
            int length = lenA - lenB;
            while (length > 0) {
                curA = curA.next;
                length--;
            }
        } else {
            int length = lenB - lenA;
            while (length > 0) {
                curB = curB.next;
                length--;
            }
        }
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }

    /**
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /**
     * 中序遍历二叉树
     *
     * @param root 树
     * @return 树中的值
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        //进行递归遍历
        insertTree(root, res);
        return res;
    }

    private void insertTree(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        //左中右
        insertTree(root.left, res);
        res.add(root.val);
        insertTree(root.right, res);
    }

    /**
     * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数
     *
     * @param root 树
     * @return 返回树的深度值
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //进行递归遍历树的最大值
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        //加1 是树根
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }

    /**
     * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
     *
     * @param root 树
     * @return 返回反转后的树
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(temp);
        return root;
    }

    /**
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     *
     * @param root 树
     * @return 返回是否是对称二叉树
     */
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return symmetric(root.left,root.right);
    }

    private boolean symmetric(TreeNode left,TreeNode right) {
        if(left==null && right==null){
            return true;
        }
        if(left==null || right==null){
            return false;
        }
        return left.val==right.val && symmetric(left.left,right.right) && symmetric(left.right,right.left);
    }

    /**
     * 树的二进制
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
