package org.hl.springlearn.leetcode.s101_150;

/**
 * 验证回文串
 * <p>如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * <p>字母和数字都属于字母数字字符。
 * <p>给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 */
class Solution125 {

    public static void main(String[] args) {
        Solution125 solution = new Solution125();
        System.out.println(solution.isPalindrome("amanaplanacanalpanama"));
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase().trim();
        if (s.isEmpty()) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char leftChar = s.charAt(left);
            if (notChar(leftChar)) {
                left++;
                continue;
            }
            char rightChar = s.charAt(right);
            if (notChar(rightChar)) {
                right--;
                continue;
            }
            if (leftChar != rightChar) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean notChar(char c) {
        // return !Character.isLetterOrDigit(c);
        return (c < '0' || c > '9') && (c < 'a' || c > 'z');
    }

}