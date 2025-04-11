package org.hl.springlearn.leetcode.s51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 格雷编码
 * <p>n 位格雷码序列 是一个由 2^n 个整数组成的序列，其中：
 * <p>  每个整数都在范围 [0, 2^n - 1] 内（含 0 和 2^n - 1）
 * <p>  第一个整数是 0
 * <p>  一个整数在序列中出现 不超过一次
 * <p>  每对 相邻 整数的二进制表示 恰好一位不同 ，且
 * <p>  第一个 和 最后一个 整数的二进制表示 恰好一位不同
 * <p>给你一个整数 n ，返回任一有效的 n 位格雷码序列 。
 */
class Solution89 {

    public static void main(String[] args) {
        System.out.println(grayCode(1));
        System.out.println(grayCode(2));
        System.out.println(grayCode(3));
        System.out.println(grayCode(4));
    }

    public static List<Integer> grayCode(int n) {
        // TODO 模板题，回顾
        // https://leetcode.cn/problems/gray-code/solutions/1198215/gong-shui-san-xie-dui-cheng-xing-gou-zao-9ap1/
        List<Integer> result = new ArrayList<>();
        result.add(0);
        while (n-- > 0) {
            int m = result.size();
            for (int i = m - 1; i >= 0; i--) {
                result.set(i, result.get(i) << 1);
                result.add(result.get(i) + 1);
            }
        }
        return result;
    }

}