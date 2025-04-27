package org.hl.springlearn.leetcode.s101_150;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角 II
 * <p>给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * <p>在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 */
class Solution119 {

    public static void main(String[] args) {
        Solution119 Solution = new Solution119();
        System.out.println(Solution.getRow(5));
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        if (rowIndex == 0) {
            return result;
        }
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> temp = new ArrayList<>(rowIndex + 1);
            temp.add(1);
            for (int j = 1; j < result.size(); j++) {
                temp.add(result.get(j - 1) + result.get(j));
            }
            temp.add(1);
            result = temp;
        }
        return result;
    }

}