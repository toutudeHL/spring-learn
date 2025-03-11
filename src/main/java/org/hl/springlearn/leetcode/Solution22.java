package org.hl.springlearn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * <p>数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
class Solution22 {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(1));
        System.out.println(generateParenthesis(2));
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(result, new char[n * 2], 0, 0, 0);
        return result;
    }

    public static void generateParenthesis(List<String> result, char[] str, int index, int left, int right) {
        if (left + right == str.length) {
            result.add(new String(str));
            return;
        }
        if (left < str.length / 2) {
            str[index] = '(';
            generateParenthesis(result, str, index + 1, left + 1, right);
        }
        if (right < left) {
            str[index] = ')';
            generateParenthesis(result, str, index + 1, left, right + 1);
        }
    }

}