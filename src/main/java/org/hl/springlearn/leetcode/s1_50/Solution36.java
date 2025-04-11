package org.hl.springlearn.leetcode.s1_50;

import java.util.HashSet;

/**
 * 有效的数独
 * <p>请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * <p>数字 1-9 在每一行只能出现一次。
 * <p>数字 1-9 在每一列只能出现一次。
 * <p>数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 *
 * <p>注意：
 * <p>一个有效的数独（部分已被填充）不一定是可解的。
 * <p>只需要根据以上规则，验证已经填入的数字是否有效即可。
 * <p>空白格用 '.' 表示。
 */
class Solution36 {

    public static void main(String[] args) {
        char[][] sudoku = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(sudoku));

        sudoku[0][0] = '8';
        System.out.println(isValidSudoku(sudoku));
    }

    public static boolean isValidSudoku1(char[][] board) {
        char[][] row = new char[9][9];
        char[][] col = new char[9][9];
        char[][] box = new char[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int c = board[i][j] - '1';
                if (row[i][c] == 1 || col[j][c] == 1 || box[(i / 3) * 3 + j / 3][c] == 1) {
                    return false;
                }
                row[i][c] = 1;
                col[j][c] = 1;
                box[(i / 3) * 3 + j / 3][c] = 1;
            }
        }
        return true;
    }

    public static boolean isValidSudoku(char[][] board) {
        char[][] newBoard = new char[27][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                newBoard[i][j] = board[i][j];
                newBoard[j + 9][i] = board[i][j];
                newBoard[(i / 3) * 3 + j / 3 + 18][(i % 3) * 3 + j % 3] = board[i][j];
            }
        }
        boolean result = true;
        for (char[] chars : newBoard) {
            if (!isValid(chars)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean isValid(char[] chars) {
        boolean result = true;
        HashSet<Character> set = new HashSet<>();
        for (char aChar : chars) {
            if (aChar == '.') {
                continue;
            }
            if (set.contains(aChar)) {
                result = false;
                break;
            }
            set.add(aChar);
        }
        return result;
    }

}