package org.hl.meeting.ks;

import java.util.Arrays;

public class SmallestK {

    public static void main(String[] args) {
        SmallestK smallestK = new SmallestK();
        int[] result = smallestK.smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4);
        System.out.println(Arrays.toString(result));
    }

    public int[] smallestK(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        quickSort(arr, 0, arr.length - 1);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    public void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left, r = right;
        int pivot = arr[right];
        while (left < right) {
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];
        }
        arr[left] = pivot;
        quickSort(arr, l, left - 1);
        quickSort(arr, left + 1, r);
    }


}
