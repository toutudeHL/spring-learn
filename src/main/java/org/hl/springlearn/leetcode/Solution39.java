package org.hl.springlearn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和
 * <p>给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * <p>对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 */
class Solution39 {

    public static void main(String[] args) {
        System.out.println(combinationSum1(new int[]{2, 3, 6, 7}, 7));
        System.out.println(combinationSum1(new int[]{2, 3, 5}, 8));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        candidates = Arrays.stream(candidates).sorted().toArray();
        if (candidates == null || candidates.length == 0 || target < candidates[0]) {
            return result;
        }
        int start = 0;
        while (start < candidates.length) {
            if (candidates[start] == target) {
                ArrayList<Integer> objects = new ArrayList<>();
                objects.add(candidates[start]);
                result.add(objects);
            }
            List<List<Integer>> temp = combinationSum(candidates, target - candidates[start]);
            if (!temp.isEmpty()) {
                for (List<Integer> list : temp) {
                    list.add(candidates[start]);
                    list.sort(Integer::compareTo);
                    if (result.contains(list)) {
                        continue;
                    }
                    result.add(list);
                }
            }
            start++;
        }
        return result;
    }

    /**
     * 优化
     * 首先将递归部分抽离，避免重复对数组进行排序
     * 然后通过while循环，从start处开始递归，避免生成重复子集（剪枝）
     * 然后将大于target的部分直接返回，避免重复计算（剪枝）
     */
    public static List<List<Integer>> combinationSum1(int[] candidates, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, result, new ArrayList<>(), 0);
        return result;
    }

    private static void backtrack(int[] candidates, int target, ArrayList<List<Integer>> result, ArrayList<Integer> single, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(single));
            return;
        }
        while (start < candidates.length && target >= candidates[start]) {
            single.add(candidates[start]);
            backtrack(candidates, target - candidates[start], result, single, start);
            single.remove(single.size() - 1);
            start++;
        }
    }

}