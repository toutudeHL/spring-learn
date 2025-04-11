package org.hl.springlearn.leetcode.s51_100;

/**
 * 最小路径和
 * <p>给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>说明：每次只能向下或者向右移动一步。
 */
class Solution64 {

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length - 1;
        int n = grid[0].length - 1;
        for (int i = 0; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[m][n];
    }

    public static int minPathSum1(int[][] grid) {
        // 优化为一维数组
        int m = grid.length - 1;
        int n = grid[0].length - 1;
        int[] dp = new int[n + 1];
        // 初始化第一行，需要将第一行数值累加
        dp[0] = grid[0][0];
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i - 1] + grid[0][i];
        }
        // 从第二行开始，需要将第一列数值累加并取最小值
        for (int i = 1; i <= m; ++i) {
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j <= n; ++j) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
            }
        }
        return dp[n];
    }

}