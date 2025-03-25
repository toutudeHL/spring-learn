package org.hl.springlearn.leetcode;

/**
 * 最后一个单词的长度
 * <p>给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * <p>单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 */
class Solution58 {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("hello world"));
    }

    public static int lengthOfLastWord(String s) {
        int count = 0;
        int length = s.length();
        int index = length - 1;
        boolean flag = false;
        while (index >= 0) {
            if (s.charAt(index) == ' ') {
                if (flag) {
                    break;
                }
            } else {
                flag = true;
                count++;
            }
            index--;
        }
        return count;
    }

}