package com.lilong.代码随想录.面试;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author :lilong
 * @date :2023-09-27-21:23
 * @description :
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String num1 = scan.next();
        String num2 = scan.next();
//        System.out.println(addStrings(num1, num2));

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry > 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            sb.append(sum % 10);
            i--;
            j--;
        }
        System.out.println(Integer.parseInt(sb.reverse().toString()));

    }
    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry > 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            sb.append(sum % 10);
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}
