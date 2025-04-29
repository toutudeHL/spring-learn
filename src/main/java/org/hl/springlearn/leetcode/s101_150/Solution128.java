package org.hl.springlearn.leetcode.s101_150;

import java.util.*;

/**
 * 最长连续序列
 * <p>给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
class Solution128 {

    public static void main(String[] args) {
        Solution128 solution = new Solution128();
        // System.out.println(solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(solution.longestConsecutive(new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6}));
        System.out.println(solution.longestConsecutive1(new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6}));
        System.out.println(solution.longestConsecutive2(new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6}));
    }

    public int longestConsecutive(int[] nums) {
        // sort 后查找最长序列 O(nlogn)
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            int temp = 1;
            if (nums[i] - nums[i - 1] > 1) {
                continue;
            } else {
                while (i < nums.length) {
                    int diff = nums[i] - nums[i - 1];
                    if (diff == 0) {
                        i++;
                    } else if (diff == 1) {
                        temp++;
                        i++;
                    } else {
                        break;
                    }
                }
            }
            result = Math.max(result, temp);
        }
        return result;
    }

    public int longestConsecutive1(int[] nums) {
        // 哈希表去重然后找最长序列 O(n)
        if (nums.length == 0) {
            return 0;
        }
        // TreeSet 保证数据有序
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        // 初始化变量为 1 ，维护两个变量，一个是当前最长序列长度，一个是当前序列长度
        int result = 1;
        int temp = 1;
        Iterator<Integer> iterator = set.iterator();
        // 维护一个 pre 变量，用于记录前一个元素
        int pre = iterator.next();
        iterator.remove();
        while (iterator.hasNext()) {
            int now = iterator.next();
            if (pre + 1 == now) {
                temp++;
            } else {
                result = Math.max(result, temp);
                temp = 1;
            }
            // 每次都需要更新 pre
            pre = now;
            iterator.remove();
        }
        // 存在最后一个序列没有比较的情况，所以需要再比较一次
        return Math.max(result, temp);
    }

    public int longestConsecutive2(int[] nums) {
        int result = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int start : set) { // 遍历哈希集合
            // 存在比 start 小的数字，直接跳过，因为 start-1 的最长长度 肯定比 start 的最长长度 要大
            if (set.contains(start - 1)) {
                continue;
            }
            // start 是序列的起点
            int end = start + 1;
            while (set.contains(end)) { // 不断查找下一个数是否在哈希集合中
                end++;
            }
            // 循环结束后，end-1 是最后一个在哈希集合中的数
            result = Math.max(result, end - start); // 从 start 到 end-1 一共 end-start 个数
        }
        return result;
    }

}