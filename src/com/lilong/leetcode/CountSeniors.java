package com.lilong.leetcode;

/**
 * @author : lilong
 * @date : 2023-10-24 11:06
 * @description :
 */
public class CountSeniors {
    /**
     *
     * @param details 数组
     * @return
     */
    public int countSeniors(String[] details) {
        int count = 0;
        for (int i = 0; i < details.length; i++) {
            if (Integer.valueOf(details[i].substring(11, 13)) > 60) {
                count++;
            }
        }
        return count;
    }
}
