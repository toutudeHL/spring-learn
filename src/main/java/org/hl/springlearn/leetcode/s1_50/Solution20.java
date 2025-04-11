package org.hl.springlearn.leetcode.s1_50;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 有效的括号
 * <p>给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>有效字符串需满足：
 * <p>左括号必须用相同类型的右括号闭合。
 * <p>左括号必须以正确的顺序闭合。
 * <p>每个右括号都有一个对应的相同类型的左括号。
 * <p>
 * 示例 1：
 * <p>输入：s = "()"
 * <p>输出：true
 * <p>
 * 示例 2：
 * <p>输入：s = "()[]{}"
 * <p>输出：true
 * <p>
 * 示例 3：
 * <p>输入：s = "(]"
 * <p>输出：false
 * <p>
 * 示例 4：
 * <p>输入：s = "([])"
 * <p>输出：true
 * <p>
 * 提示：
 * <p>1 <= s.length <= 104
 * <p>s 仅由括号 '()[]{}' 组成
 */
class Solution20 {

    public static void main(String[] args) {
        // System.out.println(isValid("()"));
        // System.out.println(isValid("()[]{}"));
        // System.out.println(isValid("(]"));
        System.out.println(isValid("([])"));
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        char[] charArray = s.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        for (char c : charArray) {
            if (c == '(') {
                list.add(')');
            } else if (c == '[') {
                list.add(']');
            } else if (c == '{') {
                list.add('}');
            } else {
                if (list.isEmpty() || list.get(list.size() - 1) != c) {
                    return false;
                }
                list.remove(list.size() - 1);
            }
        }
        return list.isEmpty();
    }

    public static boolean isValid2(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.empty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.empty();
    }
}