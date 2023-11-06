package com.lilong.面试;

import java.util.Scanner;

/**
 * @author : lilong
 * @date : 2023-10-31 14:02
 * @description :
 */
public class Cloud_IsPalindromeStr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(isPalindrome(str));
    }

    public static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(str.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(str.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }

}
