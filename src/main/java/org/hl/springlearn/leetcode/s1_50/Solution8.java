package org.hl.springlearn.leetcode.s1_50;

/**
 * 字符串转换整数 (atoi)
 * <p>请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数。
 * <p>
 * 函数 myAtoi(string s) 的算法如下：
 * <p>空格：读入字符串并丢弃无用的前导空格（" "）
 * <p>符号：检查下一个字符（假设还未到字符末尾）为 '-' 还是 '+'。如果两者都不存在，则假定结果为正。
 * <p>转换：通过跳过前置零来读取该整数，直到遇到非数字字符或到达字符串的结尾。如果没有读取数字，则结果为0。
 * <p>舍入：如果整数数超过 32 位有符号整数范围 [−2^31,  2^31 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −2^31 的整数应该被舍入为 −2^31 ，大于 2^31 − 1 的整数应该被舍入为 2^31 − 1 。
 * <p>返回整数作为最终结果。
 * <p>
 * 示例 1：
 * <p>输入：s = "42"
 * <p>输出：42
 * <p>解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
 * <p>带下划线线的字符是所读的内容，插入符号是当前读入位置。
 * <p>第 1 步："42"（当前没有读入字符，因为没有前导空格）
 * <p>第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
 * <p>第 3 步："42"（读入 "42"）
 * <p>
 * 示例 2：
 * <p>输入：s = " -042"
 * <p>输出：-42
 * <p>解释：
 * <p>第 1 步："   -042"（读入前导空格，但忽视掉）
 * <p>第 2 步："   -042"（读入 '-' 字符，所以结果应该是负数）
 * <p>第 3 步："   -042"（读入 "042"，在结果中忽略前导零）
 * <p>
 * 示例 3：
 * <p>输入：s = "1337c0d3"
 * <p>输出：1337
 * <p>解释：
 * <p>第 1 步："1337c0d3"（当前没有读入字符，因为没有前导空格）
 * <p>第 2 步："1337c0d3"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
 * <p>第 3 步："1337c0d3"（读入 "1337"；由于下一个字符不是一个数字，所以读入停止）
 * <p>
 * 示例 4：
 * <p>输入：s = "0-1"
 * <p>输出：0
 * <p>解释：
 * <p>第 1 步："0-1" (当前没有读入字符，因为没有前导空格)
 * <p>第 2 步："0-1" (当前没有读入字符，因为这里不存在 '-' 或者 '+')
 * <p>第 3 步："0-1" (读入 "0"；由于下一个字符不是一个数字，所以读入停止)
 * <p>
 * 示例 5：
 * <p>输入：s = "words and 987"
 * <p>输出：0
 * <p>解释：
 * <p>读取在第一个非数字字符“w”处停止。
 * <p>
 * 提示：
 * <p>0 <= s.length <= 200
 * <p>s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成
 */
class Solution8 {

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi(" -042"));
        System.out.println(myAtoi("1337c0d3"));
        System.out.println(myAtoi("0-1"));
        System.out.println(myAtoi("+1"));
    }

    public static int myAtoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        if (s.charAt(0) != '-' && s.charAt(0) != '+' && (s.charAt(0) > '9' || s.charAt(0) < '0')) {
            return 0;
        }
        boolean flag = s.charAt(0) == '-';
        int result = 0;
        for (int i = (flag || s.charAt(0) == '+') ? 1 : 0; i < s.length(); i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                break;
            }
            int digit = s.charAt(i) - '0';
            // 判断是否越界
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result * 10 + digit;
        }
        result = flag ? -result : result;
        return result;
    }
}