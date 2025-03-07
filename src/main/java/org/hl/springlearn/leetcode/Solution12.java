package org.hl.springlearn.leetcode;

/**
 * 整数转罗马数字
 * <p>七个不同的符号代表罗马数字，其值如下：
 * <p>符号	值
 * <p> I	1
 * <p> V	5
 * <p> X	10
 * <p> L	50
 * <p> C	100
 * <p> D	500
 * <p> M	1000
 * <p>罗马数字是通过添加从最高到最低的小数位值的转换而形成的。将小数位值转换为罗马数字有以下规则：
 * <p>
 * <p>如果该值不是以 4 或 9 开头，请选择可以从输入中减去的最大值的符号，将该符号附加到结果，减去其值，然后将其余部分转换为罗马数字。
 * <p>如果该值以 4 或 9 开头，使用 减法形式，表示从以下符号中减去一个符号，例如 4 是 5 (V) 减 1 (I): IV ，9 是 10 (X) 减 1 (I)：IX。仅使用以下减法形式：4 (IV)，9 (IX)，40 (XL)，90 (XC)，400 (CD) 和 900 (CM)。
 * <p>只有 10 的次方（I, X, C, M）最多可以连续附加 3 次以代表 10 的倍数。你不能多次附加 5 (V)，50 (L) 或 500 (D)。如果需要将符号附加4次，请使用 减法形式。
 * <p>给定一个整数，将其转换为罗马数字。
 * <p>
 * 示例 1：
 * <p>输入：num = 3749
 * <p>输出："MMMDCCXLIX"
 * <p>解释：
 * <p>3000 = MMM 由于 1000 (M) + 1000 (M) + 1000 (M)
 * <p> 700 = DCC 由于 500 (D) + 100 (C) + 100 (C)
 * <p>  40 = XL 由于 50 (L) 减 10 (X)
 * <p>   9 = IX 由于 10 (X) 减 1 (I)
 * <p>注意：49 不是 50 (L) 减 1 (I) 因为转换是基于小数位
 * <p>
 * 示例 2：
 * <p>输入：num = 58
 * <p>输出："LVIII"
 * <p>解释：
 * <p>50 = L
 * <p> 8 = VIII
 * <p>
 * 示例 3：
 * <p>输入：num = 1994
 * <p>输出："MCMXCIV"
 * <p>解释：
 * <p>1000 = M
 * <p> 900 = CM
 * <p>  90 = XC
 * <p>   4 = IV
 * <p>
 * 提示：
 * <p>1 <= num <= 3999
 */
class Solution12 {

    public static void main(String[] args) {
        System.out.println(intToRoman(3749));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
    }

    public static String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            return "";
        }
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            while (num >= nums[i]) {
                num -= nums[i];
                sb.append(romans[i]);
            }
        }
        return sb.toString();
    }
}