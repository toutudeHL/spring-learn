package org.hl.springlearn.leetcode.s51_100;

import java.util.Arrays;

/**
 * 矩阵置零
 * <p>给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 */
class Solution73 {

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void setZeroes(int[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;
        int row = -1, col = -1;
        // 标记初始行列及相关行列
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (matrix[i][j] == 0) {
                    if (row == -1) {
                        row = i;
                        col = j;
                    } else {
                        // 在初始行列上修改为0
                        matrix[row][j] = 0;
                        matrix[i][col] = 0;
                    }
                }
            }
        }
        // 没有需要修改的直接返回
        if (row == -1) {
            return;
        }
        // 除初始行列的剩余行列置0
        for (int i = 0; i < x; i++) {
            if (i == row) {
                continue;
            }
            if (matrix[i][col] == 0) {
                for (int j = 0; j < y; j++) {
                    if (j == col) {
                        continue;
                    }
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < y; j++) {
            if (j == col) {
                continue;
            }
            if (matrix[row][j] == 0) {
                for (int i = 0; i < x; i++) {
                    if (i == row) {
                        continue;
                    }
                    matrix[i][j] = 0;
                }
            }
        }
        // 初始行列置0
        for (int i = 0; i < x; i++) {
            matrix[i][col] = 0;
        }
        for (int j = 0; j < y; j++) {
            matrix[row][j] = 0;
        }
    }

}