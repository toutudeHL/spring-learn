package org.hl.springlearn.leetcode.s101_150;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词拆分
 * <p>给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * <p>注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 */
class Solution139 {

    public static void main(String[] args) {
        Solution139 solution = new Solution139();
        System.out.println(solution.wordBreak("abcd", new ArrayList<>(List.of("a", "abc", "b", "cd"))));
        System.out.println(solution.wordBreak1("abcd", new ArrayList<>(List.of("a", "abc", "b", "cd"))));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        // "ccbb"   ["bc","cb"]  43 / 47 失败且无法解决
        // 倒序排序，贪心匹配
        wordDict.sort((o1, o2) -> o2.length() - o1.length());
        for (int i = 0; i < wordDict.size(); i++) {
            if (!s.contains(wordDict.get(i))) {
                continue;
            }
            String temp = s.replace(wordDict.get(i), "");
            for (String word : wordDict) {
                if (temp.contains(word)) {
                    temp = temp.replace(word, "");
                }
                if (temp.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean wordBreak1(String s, List<String> wordDict) {
        // TODO 回顾动态规划解法
        // 将字典列表转换为集合，利用集合的 O(1) 查找复杂度提高性能
        Set<String> wordSet = new HashSet<>(wordDict);
        // 创建动态规划数组，dp[i] 表示字符串 s 的前 i 个字符是否可以由字典中的单词拼接而成
        // 长度为 s.length() + 1 是为了处理空字符串的情况，dp[0] 表示空字符串
        boolean[] dp = new boolean[s.length() + 1];
        // 空字符串可以由字典中的单词拼接而成（不需要任何单词），所以初始化为 true
        dp[0] = true;

        // 遍历字符串 s 的所有可能长度，从 1 到 s.length()
        for (int i = 1; i <= s.length(); i++) {
            // 尝试将字符串 s 的前 i 个字符拆分为两部分，前 j 个字符和从 j 到 i 的子字符串
            for (int j = 0; j < i; j++) {
                // 如果前 j 个字符可以由字典中的单词拼接而成（dp[j] 为 true）
                // 并且从 j 到 i 的子字符串存在于字典中
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    // 则说明前 i 个字符可以由字典中的单词拼接而成，更新 dp[i] 为 true
                    dp[i] = true;
                    // 找到一种拆分方式后，无需继续尝试其他拆分，跳出内层循环
                    break;
                }
            }
        }

        // 返回整个字符串 s 是否可以由字典中的单词拼接而成的结果
        return dp[s.length()];
    }

}

