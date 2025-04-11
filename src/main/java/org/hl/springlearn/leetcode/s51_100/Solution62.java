package org.hl.springlearn.leetcode.s51_100;

/**
 * 不同路径
 * <p>一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>问总共有多少条不同的路径？
 */
class Solution62 {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePaths(3, 2));
        System.out.println(uniquePaths(7, 3));
        System.out.println(uniquePaths(3, 3));
    }

    public static int uniquePaths(int m, int n) {
        // 动态规划
        int[][] dp = new int[m][n];
        //第一行都赋予 1
        for (int i = 0; i < m; ++i) {
            dp[i][0] = 1;
        }
        //第一列都赋予 1
        for (int j = 0; j < n; ++j) {
            dp[0][j] = 1;
        }
        //两个for循环推导，对于(i,j)来说，只能由上方或者左方转移过来
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static int uniquePaths1(int m, int n) {
        // TODO：递归超时，可以加个缓存
        return dfs(m, n, 0, 0);
    }

    public static int dfs(int m, int n, int i, int j) {
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (i >= m || j >= n) {
            return 0;
        }
        return dfs(m, n, i + 1, j) + dfs(m, n, i, j + 1);
    }

}