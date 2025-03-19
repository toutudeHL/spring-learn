package org.hl.springlearn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列 II
 * <p>给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */
class Solution47 {

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 1, 2}));
        System.out.println(permute1(new int[]{1, 1, 2}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        backtrack(result, new ArrayList<>(), nums, used, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used, int index) {
        if (index == nums.length) {
            if (!result.contains(tempList)) {
                result.add(new ArrayList<>(tempList));
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            tempList.add(nums[i]);
            used[i] = true;
            backtrack(result, tempList, nums, used, index + 1);
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }

    public static List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        boolean[] used = new boolean[nums.length];
        // 添加排序，对重复元素剪枝
        Arrays.sort(nums);
        Arrays.fill(used, false);
        backtrack1(result, new ArrayList<>(), nums, used, 0);
        return result;
    }

    private static void backtrack1(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used, int index) {
        if (index == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // 同40题，对重复元素剪枝
            if (i > 0 && !used[i - 1] && nums[i] == nums[i - 1]) {
                continue;
            }
            tempList.add(nums[i]);
            used[i] = true;
            backtrack1(result, tempList, nums, used, index + 1);
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }

}