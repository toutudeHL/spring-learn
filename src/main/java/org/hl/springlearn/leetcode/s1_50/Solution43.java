package org.hl.springlearn.leetcode.s1_50;

/**
 * 字符串相乘
 * <p>给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 */
class Solution43 {

    public static void main(String[] args) {
        System.out.println(multiply("2", "3"));
        System.out.println(multiply("123", "456"));
    }

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        int[] tempArray = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                int multiply = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // 模拟乘法计算，此处 +1 是为了保留最左侧进位的情况
                int index = i + j + 1;
                tempArray[index] += multiply;
                while (tempArray[index] >= 10 && index > 0) {
                    tempArray[index - 1] += tempArray[index] / 10;
                    tempArray[index] %= 10;
                    index--;
                }
            }
        }
        for (int i = 0; i < tempArray.length; i++) {
            if (i == 0 && tempArray[i] == 0) {
                // 此处表示最左侧没有进位，直接跳过
                continue;
            }
            result.append(tempArray[i]);
        }
        return result.toString();
    }

}