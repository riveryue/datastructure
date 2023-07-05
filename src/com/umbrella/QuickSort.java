package com.umbrella;

import java.util.Arrays;

/**
 * 快速排序之双指针实现
 */
public class QuickSort {
    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = arr[left];
        int i = left - 1;
        int j = right + 1;
        while (i < j) {
            //从左指针开始找到第一个大于基准值的元素对应的下标
            do {
                i++;
            } while (arr[i] < pivot);
            //从右指针开始找到第一个小于基准值的元素对应的下标
            do {
                j--;
            } while (arr[j] > pivot);
            if (i < j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        quickSort(arr, left, j);
        quickSort(arr, j + 1, right);
    }

    public static void main(String[] args) {
        int[] arr = {30, 40, 60, 10, 20, 50, 40};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
