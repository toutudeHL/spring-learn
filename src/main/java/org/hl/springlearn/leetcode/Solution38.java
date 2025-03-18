package org.hl.springlearn.leetcode;

/**
 * 外观数列
 * <p>「外观数列」是一个数位字符串序列，由递归公式定义：
 * <p>  countAndSay(1) = "1"
 * <p>  countAndSay(n) 是 countAndSay(n-1) 的行程长度编码。
 * <p>
 * 行程长度编码（RLE）是一种字符串压缩方法，其工作原理是通过将连续相同字符（重复两次或更多次）替换为字符重复次数（运行长度）和字符的串联。例如，要压缩字符串 "3322251" ，我们将 "33" 用 "23" 替换，将 "222" 用 "32" 替换，将 "5" 用 "15" 替换并将 "1" 用 "11" 替换。因此压缩后字符串变为 "23321511"。
 * <p>
 * 给定一个整数 n ，返回 外观数列 的第 n 个元素。
 */
class Solution38 {

    public static void main(String[] args) {
        // 该测试用例只有30个，还可以通过静态方法预先生成所有的结果到数组中，然后通过n下标直接返回
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(1));
    }

    public static String countAndSay(int n) {
        String result = "1";
        int count = 1;
        while (count < n) {
            count++;
            result = countAndSay(result);
        }
        return result;
    }

    public static String countAndSay(String str) {
        StringBuilder result = new StringBuilder();
        char[] charArray = str.toCharArray();
        char pre = charArray[0];
        int count = 0;
        for (char c : charArray) {
            if (c == pre) {
                count++;
            } else {
                result.append(count);
                result.append(pre);
                pre = c;
                count = 1;
            }
        }
        result.append(count);
        result.append(pre);
        return result.toString();
    }

}