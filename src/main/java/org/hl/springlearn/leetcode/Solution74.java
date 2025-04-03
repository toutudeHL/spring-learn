package org.hl.springlearn.leetcode;

/**
 * 搜索二维矩阵
 * <p>给你一个满足下述两条属性的 m x n 整数矩阵：
 * <p>  每行中的整数从左到右按非严格递增顺序排列。
 * <p>  每行的第一个整数大于前一行的最后一个整数。
 * <p>给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 */
class Solution74 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        System.out.println(searchMatrix(matrix, 30));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int top = 0, bottom = m - 1;
        while (top <= bottom) {
            int mid = top + (bottom - top) / 2;
            int midValue = matrix[mid][n - 1];
            if (target < midValue) {
                bottom = mid - 1;
            } else if (target > midValue) {
                top = mid + 1;
            } else {
                return true;
            }
        }
        int row = bottom + 1;
        if (row < 0 || row >= m) {
            return false;
        }
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[row][mid];
            if (target < midValue) {
                right = mid - 1;
            } else if (target > midValue) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length, n = matrix[0].length;

        // 将二维矩阵视为一个有序的一维数组，通过一次二分查找完成搜索
        int left = 0, right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / n][mid % n];

            if (target < midValue) {
                right = mid - 1;
            } else if (target > midValue) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }

}