package com.inori.util.sort;

import java.util.Arrays;

/**
 * QuickSort
 * 快速排序，其实就是对冒泡排序的优化，由于快速排序一次交换两个数，
 * 所以一趟快速排序可以比冒泡少交换一倍，并且由于快排的分治思想，
 * 快排只需要（log n）趟就可以完成所有排序，每趟都要遍历数组所有节点，
 * 故每趟时间复杂度为n，总时间复杂度为O(nlogn)。
 * <p>
 * 时间复杂度：O(nlogn)，空间复杂度：O(1)
 *
 * @author inori
 * @date 2020/12/3
 */
public class QuickSort implements Sorter {
    @Override
    public int[] sort(int[] source) {
        return quickSort(source, 0, source.length - 1);
    }

    private int[] quickSort(int[] source, int left, int right) {
        if (left >= right) {
            return source;
        }
        //选择left为基准值
        int i = left, j = right;
        while (i < j) {
            if (source[j] > source[left]) {
                j--;
                continue;
            }
            if (source[i] <= source[left]) {
                i++;
                continue;
            }
            swap(source, i, j);
        }
        swap(source, left, j);

        quickSort(source, left, i - 1);
        quickSort(source, i + 1, right);
        return source;
    }

    private void swap(int[] source, int i, int j) {
        int temp = source[i];
        source[i] = source[j];
        source[j] = temp;
    }

}
