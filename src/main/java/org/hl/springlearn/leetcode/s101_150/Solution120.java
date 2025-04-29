package org.hl.springlearn.leetcode.s101_150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三角形最小路径和
 * <p>给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * <p>每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 */
class Solution120 {

    public static void main(String[] args) {
        Solution120 solution = new Solution120();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(List.of(2));
        triangle.add(List.of(3, 4));
        triangle.add(List.of(6, 5, 7));
        triangle.add(List.of(4, 1, 8, 3));
        System.out.println(solution.minimumTotal(triangle));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        // 自上而下
        int row = triangle.size();
        int col = triangle.get(row - 1).size();
        // 定义dp数组
        int[][] dp = new int[row][col];
        // 初始化第一行
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < row; i++) {
            // 此处需要注意范围，每行的长度都是和行数相同的
            for (int j = 0; j <= i; j++) {
                // 获取当前数值
                dp[i][j] = triangle.get(i).get(j);
                if (j == 0) {
                    // 最左侧为 当前数值 + 头顶数值
                    dp[i][j] = dp[i][j] + dp[i - 1][j];
                } else if (j == i) {
                    // 最右侧为 当前数值 + 头顶左侧数值
                    dp[i][j] = dp[i][j] + dp[i - 1][j - 1];
                } else {
                    // 其余位置则是上述 两种情况 的最小值
                    dp[i][j] = dp[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }
            }
        }

        // 此时最后一行数组为所有可达路径的数值，再找出其中的最小值
        int result = dp[row - 1][0];
        for (int i = 1; i < col; i++) {
            result = Math.min(result, dp[row - 1][i]);
        }

        return result;
    }

    public int minimumTotal1(List<List<Integer>> triangle) {
        // 递归，自下而上 https://leetcode.cn/problems/triangle/solutions/2997752/jiao-ni-yi-bu-bu-si-kao-dpcong-ji-yi-hua-42r2/
        int n = triangle.size();
        int[][] memo = new int[n][n];
        for (int[] row : memo) {
            // Integer.MIN_VALUE 表示没有计算过
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return dfs(triangle, 0, 0, memo);
    }

    private int dfs(List<List<Integer>> triangle, int i, int j, int[][] memo) {
        if (i == triangle.size() - 1) {
            // 最后一层是当前值
            return triangle.get(i).get(j);
        }
        if (memo[i][j] != Integer.MIN_VALUE) {
            // 之前计算过
            return memo[i][j];
        }
        return memo[i][j] = Math.min(dfs(triangle, i + 1, j, memo), dfs(triangle, i + 1, j + 1, memo))
                + triangle.get(i).get(j);
    }

}