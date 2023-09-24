package com.lilong.代码随想录.贪心算法;

import java.util.Arrays;

/**
 * @author :lilong
 * @date :2023-09-17-18:21
 * @description : 分享饼干
 */
public class ShareCookies {
    /**
     * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
     * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；
     * 并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，
     * 这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
     *
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren1(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        //小饼干先喂饱小胃口
        int index = 0;
        for (int i = 0; i < s.length; i++) {
            if (index < g.length && g[index] <= s[i]) {
                index++;
            }
        }
        return index;
    }

    /**
     * 大饼干先喂饱大胃口
     *
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index = 0;
        int count = 0;
        for (int i = s.length - 1; i >= 0; i--) {
            if (index <= g.length && g[index] <= s[i]) {
                index++;
                count++;
            }
        }
        return count;
    }
}
