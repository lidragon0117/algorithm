package com.lilong.面试;

/**
 * @author : lilong
 * @date : 2023-11-07 19:42
 * @description :
 */
public class SearchTargetsNum {

    public static void main(String[] args) {
        //System.out.println(search(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0}, 10));
        int x =62;
        boolean isPowerOfTwo = (x > 0) && ((x & (x - 1)) == 0);
        System.out.println(isPowerOfTwo);
    }
    public static int search(int[] n, int M) {
        int count = 0;
        for (int i = 0; i < n.length; i++) {
            for (int j = i + 1; j < n.length; j++) {
                if (n[i] + n[j] == M) {
                    count++;
                }
            }
        }
        return count;
    }


}
