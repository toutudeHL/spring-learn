package org.hl.springlearn.leetcode.s201_250;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 数组中的第K个最大元素
 * <p>给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
class Solution214 {

    public static void main(String[] args) {
        Solution214 solution = new Solution214();
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        // 快排
        System.out.println(solution.findKthLargest(nums, 3));
        // 分治
        System.out.println(solution.findKthLargest1(nums, 3));
    }

    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    public void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            // partition就是划分操作，将arr划分成满足条件的两个子表
            int n = partition(arr, l, r);
            // 依次对左右两个子表进行递归排序
            quickSort(arr, l, n - 1);
            quickSort(arr, n + 1, r);
        }
    }

    public int partition(int[] arr, int l, int r) {
        // 以当前数组的最后一个元素作为中枢pivot，进行划分
        int pivot = arr[r];
        while (l < r) {
            // 将比中枢值大的移动到右端r处 由于r处为中枢或者该位置值已经被替换到l处，所以直接可以替换
            while (l < r && arr[l] < pivot) {
                l++;
            }
            arr[r] = arr[l];
            // 将比中枢值小的移动到左端l处 由于前面l处的值已经换到r处，所以该位置值也可以替换掉
            while (l < r && arr[r] >= pivot) {
                r--;
            }
            arr[l] = arr[r];
        }
        // l==r时，重合，这个位置就是中枢的最终位置
        arr[l] = pivot;
        // 返回存放中枢的最终位置
        return l;
    }

    public int findKthLargest1(int[] nums, int k) {
        List<Integer> temp = new ArrayList<>(nums.length);
        for (int num : nums) {
            temp.add(num);
        }
        return find(temp, k);
    }

    public int find(List<Integer> temp, int k) {
        Random random = new Random();
        int pivot = temp.get(random.nextInt(temp.size()));
        List<Integer> less = new ArrayList<>();
        List<Integer> equals = new ArrayList<>();
        List<Integer> great = new ArrayList<>();
        for (Integer num : temp) {
            if (num < pivot) {
                less.add(num);
            } else if (num > pivot) {
                great.add(num);
            } else {
                equals.add(num);
            }
        }
        if (k <= great.size()) {
            return find(great, k);
        } else if (great.size() + equals.size() < k) {
            return find(less, k - great.size() - equals.size());
        } else {
            return pivot;
        }
    }

}