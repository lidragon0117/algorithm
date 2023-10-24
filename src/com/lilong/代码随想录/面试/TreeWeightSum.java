package com.lilong.代码随想录.面试;

import java.util.Scanner;

/**
 * @author :lilong
 * @date :2023-10-21-9:51
 * @description :  这个是小美一棵有根数 根节点为1号节点
 */
import java.util.Scanner;



public class TreeWeightSum {
    static int n; // 节点数量
    static int[] a = new int[100010]; // 节点初始权值
    static int[] sum = new int[100010]; // 节点权值之和
    static int[] parent = new int[100010]; // 节点父节点
    static int[] edge = new int[100010]; // 边权值
    static int[] uv = new int[100010]; // u 和 v 的边
    static int q; // 操作次数

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            uv[i] = u;
            uv[n - 1 - i] = v;
            edge[i] = sc.nextInt();
        }
        q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int u = sc.nextInt();
            int z = sc.nextInt();
            int x = sc.nextInt();
            for (int j = 0; j < n; j++) {
                if (edge[j] == u) {
                    parent[j] = u;
                }
            }
            dfs(u, x, uv, edge, parent, sum);
        }
        System.out.println(getSum());
    }

    public static void dfs(int u, int x, int[] uv, int[] edge, int[] parent, int[] sum) {
        for (int i = 0; i < n; i++) {
            if (parent[i] == u) {
                if (i == u) {
                    sum[i] = a[i] * x;
                } else {
                    sum[i] = a[i] * x + sum[parent[i]];
                }
                dfs(i, x, uv, edge, parent, sum);
            }
        }
    }

    public static int getSum() {
        int s = 0;
        for (int i = 0; i < n; i++) {
            s += sum[i];
        }
        return s;
    }
}

