package org.hl.springlearn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 * <p>给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>你可以按 任何顺序 返回答案。
 */
class Solution77 {

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), n, k, 1);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int n, int k, int index) {
        if (tempList.size() == k) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        // 可以使用 i <= n - (k - tempList.size()) + 1 进行剪枝，对于长度不满足的遍历直接跳过
        for (int i = index; i <= n; i++) {
            tempList.add(i);
            backtrack(result, tempList, n, k, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

}