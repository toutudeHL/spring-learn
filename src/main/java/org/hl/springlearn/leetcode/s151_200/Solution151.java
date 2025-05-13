package org.hl.springlearn.leetcode.s151_200;

/**
 * 反转字符串中的单词
 * <p>给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * <p>单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * <p>返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * <p>注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 */
class Solution151 {

    public static void main(String[] args) {
        Solution151 solution = new Solution151();
        String s = "a good   example";
        System.out.println(solution.reverseWords(s));
    }

    private static int getRightIndex(String s, int right, char space) {
        while (right >= 0 && s.charAt(right) == space) {
            right--;
        }
        return right;
    }

    private static void subAndAppend(String s, int left, int right, StringBuilder result, char space) {
        String temp = s.substring(left + 1, right + 1);
        if (result.length() > 0) {
            // 前置空格
            result.append(space);
        }
        result.append(temp);
    }

    public String reverseWords(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        int length = s.length();

        // 从末尾最后一个非空字符开始倒序查询
        int left, right = length - 1;
        char space = ' ';
        right = getRightIndex(s, right, space);
        left = right - 1;

        while (left >= 0) {
            if (s.charAt(left) == space) {
                subAndAppend(s, left, right, result, space);
                // 跳过多余空格，继续从下一个非空字符开始查询
                right = left;
                right = getRightIndex(s, right, space);
                left = right - 1;
            } else {
                left--;
            }
        }
        // 添加最后一个单词
        if (right >= 0 && s.charAt(right) != space) {
            subAndAppend(s, left, right, result, space);
        }

        return result.toString();
    }

}

