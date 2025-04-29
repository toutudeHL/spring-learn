package org.hl.springlearn.leetcode.s101_150;

import java.util.Arrays;

/**
 * 被围绕的区域
 * <p>给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' 组成，捕获 所有 被围绕的区域：
 * <p>  连接：一个单元格与水平或垂直方向上相邻的单元格连接。
 * <p>  区域：连接所有 'O' 的单元格来形成一个区域。
 * <p>  围绕：如果您可以用 'X' 单元格 连接这个区域，并且区域中没有任何单元格位于 board 边缘，则该区域被 'X' 单元格围绕。
 * <p>通过 原地 将输入矩阵中的所有 'O' 替换为 'X' 来 捕获被围绕的区域。你不需要返回任何值。
 */
class Solution130 {

    int[][] finds = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) {
        Solution130 solution = new Solution130();
        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        solution.solve(board);
        solution.solve1(board);
        System.out.println(Arrays.deepToString(board));
    }

    public void solve(char[][] board) {
        // 从边界寻找，找到 O 的区域标记，剩下的所有区域都为 X
        int x = board.length, y = board[0].length;
        // 0 为默认状态，1 为已标记
        int[][] mark = new int[x][y];
        // 标记上下边界的 O 区域
        for (int i = 0; i < y; i++) {
            if (board[0][i] == 'O' && mark[0][i] == 0) {
                marking(board, mark, x, y, 0, i);
            }
            if (board[x - 1][i] == 'O' && mark[x - 1][i] == 0) {
                marking(board, mark, x, y, x - 1, i);
            }
        }
        // 标记左右边界的 O 区域
        for (int i = 0; i < x; i++) {
            if (board[i][0] == 'O' && mark[i][0] == 0) {
                marking(board, mark, x, y, i, 0);
            }
            if (board[i][y - 1] == 'O' && mark[i][y - 1] == 0) {
                marking(board, mark, x, y, i, y - 1);
            }
        }
        // 未被标记的 O 元素替换为 X
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 'O' && mark[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void marking(char[][] board, int[][] mark, int x, int y, int m, int n) {
        if (mark[m][n] == 1) {
            return;
        }
        // 标记
        mark[m][n] = 1;
        // 根据 上下左右 四方向，寻找区域
        for (int[] find : finds) {
            int newM = m + find[0], newN = n + find[1];
            if (newM < 0 || newM >= x || newN < 0 || newN >= y) {
                // 超出数组范围，跳过
                continue;
            }
            // 相邻存在 O 继续寻找并标记
            if (board[newM][newN] == 'O' && mark[newM][newN] == 0) {
                marking(board, mark, x, y, newM, newN);
            }
        }
    }

    public void solve1(char[][] board) {
        // 压缩空间，将标记替换为 M ，最后剩余的 O 为未标记，需要调换为 X，而标记过的 M 要替换为 O
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        // 从边界寻找，找到 O 的区域标记，剩下的所有区域都为 X
        int x = board.length, y = board[0].length;
        // 标记上下边界的 O 区域
        for (int i = 0; i < y; i++) {
            if (board[0][i] == 'O') {
                marking(board, x, y, 0, i);
            }
            if (board[x - 1][i] == 'O') {
                marking(board, x, y, x - 1, i);
            }
        }
        // 标记左右边界的 O 区域
        for (int i = 0; i < x; i++) {
            if (board[i][0] == 'O') {
                marking(board, x, y, i, 0);
            }
            if (board[i][y - 1] == 'O') {
                marking(board, x, y, i, y - 1);
            }
        }
        // 未被标记的 O 元素替换为 X
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'M') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void marking(char[][] board, int x, int y, int m, int n) {
        // 不符合条件直接返回
        if (m < 0 || m >= x || n < 0 || n >= y || board[m][n] != 'O') {
            return;
        }
        // 标记
        board[m][n] = 'M';
        // 根据 上下左右 四方向，寻找区域
        for (int[] find : finds) {
            int newM = m + find[0], newN = n + find[1];
            marking(board, x, y, newM, newN);
        }
    }

}