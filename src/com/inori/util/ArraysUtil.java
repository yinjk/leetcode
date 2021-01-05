package com.inori.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ArraysUtil
 *
 * @author inori
 * @date 2020/3/23
 */
public abstract class ArraysUtil {

    /**
     * 二分查找算法
     *
     * @param nums   查找数组
     * @param target 目标值
     * @return 目标值在数组中的下标，若没找到则返回-1
     */
    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private static int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) return -1;
        int mid = (left + right) >> 1;
        if (target < nums[mid]) return binarySearch(nums, left, mid - 1, target);
        else if (target > nums[mid]) return binarySearch(nums, mid + 1, right, target);
        else return mid;
    }


    //============================= all of sort function ==============================


    /**
     * 归并排序（一）直接对原数组排序
     *
     * 时间复杂度：O(nlogn)  空间复杂度：O(n)
     *
     * @param nums 要排序的数组
     */
    public static void mergeSort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        mergeSort(nums, 0, nums.length - 1);
    }

    /**
     * 归并排序（二）带返回数组的方式
     *
     * @param nums 源数组
     * @return 排序后的数组
     */
    public static int[] mergeSortWithReturn(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        int left = 0, right = nums.length - 1;
        int mid = (left + right) >> 1;
        return merge(mergeSortWithReturn(Arrays.copyOfRange(nums, 0, mid + 1)), mergeSortWithReturn(Arrays.copyOfRange(nums, mid + 1, right + 1)));
    }

    public static void quickSort(int[] nums) {

    }

    private static void mergeSort(int[] nums, int left, int right) {
        int mid = (left + right) >> 1;
        if (left < mid) mergeSort(nums, left, mid);
        if (mid + 1 < right) mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private static void merge(int[] nums, int min, int mid, int max) {
        int left = min, right = mid + 1;
        List<Integer> list = new ArrayList<>();
        while (left <= mid || right <= max) {
            if (left > mid) list.add(nums[right++]);
            else if (right > max) list.add(nums[left++]);
            else if (nums[left] <= nums[right]) list.add(nums[left++]);
            else list.add(nums[right++]);
        }
        for (Integer i : list) {
            nums[min++] = i;
        }
    }

    private static int[] merge(int[] left, int[] right) {
        int i = 0, j = 0, x = 0;
        int[] list = new int[left.length + right.length];
        while (i < left.length || j < right.length) {
            if (i >= left.length) list[x++] = right[j++];
            else if (j >= right.length) list[x++] = left[i++];
            else if (left[i] < right[j]) list[x++] = left[i++];
            else list[x++] = right[j++];
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 2, 4, 5, 6, 7, 9, 10}, 8));
        int[] a = new int[]{7, 3, 4, 10, 9, 6, 7, 8};
        mergeSort(a);
        System.out.println(Arrays.toString(a));
    }


}
