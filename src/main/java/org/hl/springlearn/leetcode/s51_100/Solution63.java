package org.hl.springlearn.leetcode.s51_100;

/**
 * 不同路径 II
 * <p>给定一个 m x n 的整数数组 grid。一个机器人初始位于 左上角（即 grid[0][0]）。机器人尝试移动到 右下角（即 grid[m - 1][n - 1]）。机器人每次只能向下或者向右移动一步。
 * <p>网格中的障碍物和空位置分别用 1 和 0 来表示。机器人的移动路径中不能包含 任何 有障碍物的方格。
 * <p>返回机器人能够到达右下角的不同路径数量。
 * <p>测试用例保证答案小于等于 2 * 109。
 */
class Solution63 {

    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 动态规划
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // 如果起点或者终点有障碍物，直接返回0
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        int[][] dp = new int[m][n];
        //第一行都赋予 1，如果有障碍物，后面的都为0
        for (int i = 0; i < m; ++i) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        //第一列都赋予 1，如果有障碍物，后面的都为0
        for (int j = 0; j < n; ++j) {
            if (obstacleGrid[0][j] == 1) {
                break;
            }
            dp[0][j] = 1;
        }
        //两个for循环推导，对于(i,j)来说，只能由上方或者左方转移过来
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                // 如果当前位置有障碍物，直接跳过
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

}