package org.hl.springlearn.leetcode;

/**
 * 单词搜索
 * <p>给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
class Solution79 {

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board, "ABCCED"));
    }

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean backtrack(char[][] board, String word, int i, int j, int index) {
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        if (word.length() - 1 == index) {
            return true;
        }
        board[i][j] = 0;
        for (int m = 1; m <= 4; m++) {
            int x, y;
            // 上下左右四种情况
            if (m == 1) {
                x = i - 1;
                y = j;
            } else if (m == 2) {
                x = i;
                y = j - 1;
            } else if (m == 3) {
                x = i + 1;
                y = j;
            } else {
                x = i;
                y = j + 1;
            }
            if (0 <= x && x < board.length && 0 <= y && y < board[x].length && backtrack(board, word, x, y, index + 1)) {
                return true;
            }
        }
        board[i][j] = word.charAt(index);
        return false;
    }

}