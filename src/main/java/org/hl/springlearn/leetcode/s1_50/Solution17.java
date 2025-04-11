package org.hl.springlearn.leetcode.s1_50;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字母组合
 * <p>给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>1 -> ""
 * <p>2 -> "abc"
 * <p>3 -> "def"
 * <p>4 -> "ghi"
 * <p>5 -> "jkl"
 * <p>6 -> "mno"
 * <p>7 -> "pqrs"
 * <p>8 -> "tuv"
 * <p>9 -> "wxyz"
 * <p>
 * 示例 1：
 * <p>输入：digits = "23"
 * <p>输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * <p>
 * 示例 2：
 * <p>输入：digits = ""
 * <p>输出：[]
 * <p>
 * 示例 3：
 * <p>输入：digits = "2"
 * <p>输出：["a","b","c"]
 * <p>
 * 提示：
 * <p>0 <= digits.length <= 4
 * <p>digits[i] 是范围 ['2', '9'] 的一个数字。
 */
class Solution17 {

    private static final String[] KEYS = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations(""));
        System.out.println(letterCombinations("2"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty() || digits.length() > 4) {
            return res;
        }
        convert(res, digits.toCharArray(), 0, "");
        return res;
    }

    public static void convert(List<String> res, char[] chars, int digitsIndex, String str) {
        if (digitsIndex == chars.length) {
            res.add(str);
            return;
        }
        char[] strings = KEYS[chars[digitsIndex] - '2'].toCharArray();
        for (char string : strings) {
            convert(res, chars, digitsIndex + 1, str + string);
        }
    }
}