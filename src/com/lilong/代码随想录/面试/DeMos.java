package com.lilong.代码随想录.面试;

/**
 * @author :lilong
 * @date :2023-10-21-10:40
 * @description :
 */
public class DeMos {
    public static final  int n = 4;
    public static final   int m = 4;
    public static final char[][] matrix = new char[][]{{'A', 'B', 'C', 'E'}, {'A', 'B', 'D', 'E'}, {'C', 'A', 'B', 'A'}, {'E', 'A', 'C', 'D'}};

    public static void main(String[] args) {

       // char[][] matrix;
        int maxMoves = 0;
        //Scanner sc = new Scanner(System.in);
       // matrix = new char[][]{{'A', 'B', 'C', 'E'}, {'A', 'B', 'D', 'E'}, {'C', 'A', 'B', 'A'}, {'E', 'A', 'C', 'D'}};

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                matrix[i][j] = sc.next().charAt(0);
//            }
//        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 'A') {
                    maxMoves = Math.max(maxMoves, dfs(i, j));
                }
            }
        }

        System.out.println(maxMoves == Integer.MAX_VALUE ? -1 : maxMoves);
    }

    public static int dfs(int x, int y) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int steps = 0;

        while (true) {
            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                System.out.println("nihap ");
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && matrix[newX][newY] == 'A') {
                    x = newX;
                    y = newY;
                    steps++;
                    break;
                }
            }

            if (steps >= 5) {
                break;
            }
        }

        return steps;
    }
}

