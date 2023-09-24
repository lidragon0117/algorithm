package com.lilong.代码随想录.动态规划;

/**
 * @author :lilong
 * @date :2023-09-23-23:41
 * @description : 动态规划 存在路障
 */
public class UniquePathsWithObstacles {
    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     * <p>
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
     * <p>
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     * <p>
     * 网格中的障碍物和空位置分别用 1 和 0 来表示。
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int colLength = obstacleGrid.length;
        int rowLength = obstacleGrid[0].length;
        int[][] dp = new int[colLength][rowLength];
        if (obstacleGrid[colLength - 1][rowLength - 1] == 1 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        for (int i = 0; i < colLength && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < rowLength && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < colLength; i++) {
            for (int j = 1; j < rowLength; j++) {
                dp[i][j] = obstacleGrid[i][j] == 0 ? dp[i - 1][j] + dp[i][j - 1] : 0;
            }
        }
        return dp[colLength - 1][rowLength - 1];
    }
}
