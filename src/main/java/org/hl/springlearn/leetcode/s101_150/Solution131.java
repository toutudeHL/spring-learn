package org.hl.springlearn.leetcode.s101_150;

import java.util.ArrayList;
import java.util.List;

/**
 * 分割回文串
 * <p>给你一个字符串 s，请你将 s 分割成一些 子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 */
class Solution131 {

    public static void main(String[] args) {
        Solution131 solution = new Solution131();
        System.out.println(solution.partition("aab"));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s.length() == 1) {
            result.add(List.of(s));
            return result;
        }
        backTrack(result, new ArrayList<>(), s);
        return result;
    }

    public void backTrack(List<List<String>> result, List<String> temp, String s) {
        // 为空说明已经找到一个解
        if (s.isEmpty()) {
            result.add(new ArrayList<>(temp));
        }
        // 从 1 开始，保证至少有一个元素
        for (int i = 1; i <= s.length(); i++) {
            String s1 = s.substring(0, i);
            // 不是回文字符串，跳过
            if (!isPalindrome(s1)) {
                continue;
            }
            temp.add(s1);
            backTrack(result, temp, s.substring(i));
            temp.remove(temp.size() - 1);
        }
    }

    public boolean isPalindrome(String s) {
        // 只需要检查是否为回文字符串，不需要考虑其他情况（125题）
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}