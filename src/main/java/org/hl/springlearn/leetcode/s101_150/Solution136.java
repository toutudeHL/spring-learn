package org.hl.springlearn.leetcode.s101_150;

/**
 * 只出现一次的数字 II
 * <p>给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * <p>你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。
 */
class Solution136 {

    public static void main(String[] args) {
        Solution136 solution = new Solution136();
        int[] nums = new int[]{2, 2, 3, 2};
        System.out.println(solution.singleNumber(nums));
        System.out.println(solution.singleNumber1(nums));
    }

    public int singleNumber(int[] nums) {
        // TODO 位运算学习、回顾
        // 初始化一个长度为 32 的数组 counts ，用于记录数组中所有数字在每一位上 1 出现的次数
        // 因为 Java 中 int 类型是 32 位，所以需要 32 个位置来记录每一位的情况
        int[] counts = new int[32];
        // 遍历数组 nums 中的每个数字
        for (int num : nums) {
            // 对每个数字的 32 位进行遍历
            for (int j = 0; j < 32; j++) {
                // 使用 按位与 运算 num & 1 来检查当前数字的最低位是否为 1
                // 将结果累加到 counts 数组的对应位置
                counts[j] += num & 1;
                // 使用 无符号右移运算符 >>> 将 num 右移一位，以便检查下一位
                num >>>= 1;
            }
        }
        // 初始化结果变量 res 为0，m 为3，表示其余元素出现的次数
        int res = 0, m = 3;
        // 遍历 counts 数组，重建只出现一次的数字
        for (int i = 0; i < 32; i++) {
            // 将 res 左移一位，为下一位的结果腾出位置
            res <<= 1;
            // 使用按位或运算将 counts 数组中对应位对 m 取余的结果添加到 res 中
            // 因为其余元素都出现 3 次，所以对 3 取余后得到的就是只出现 1 次的数字在该位的值
            res |= counts[31 - i] % m;
        }
        // 返回最终结果
        return res;
    }

    public int singleNumber1(int[] nums) {
        // https://leetcode.cn/problems/single-number-ii/solutions/8944/single-number-ii-mo-ni-san-jin-zhi-fa-by-jin407891/
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

}