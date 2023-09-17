package com.lilong.代码随想录.回溯问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :lilong
 * @date :2023-09-17-14:50
 * @description : 回溯问题
 */
public class SplitString {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    /**
     * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
     * <p>
     * 回文串 是正着读和反着读都一样的字符串。
     *
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        combineBack(s, 0);
        return res;
    }

    private void combineBack(String s, int startIndex) {
        if (startIndex >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        //进行判断是否是回文函数
        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindromicNumber(s, startIndex, i)) {
                path.add(s.substring(startIndex, i + 1));
            } else {
                continue;
            }
            combineBack(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    private boolean isPalindromicNumber(String s, int startIndex, int end) {
        int left = startIndex;
        int right = end;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
