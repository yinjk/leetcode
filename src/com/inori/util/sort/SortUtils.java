package com.inori.util.sort;

import java.util.Arrays;

/**
 * SortUtils
 *
 * @author inori
 * @date 2020/12/3
 */
public class SortUtils {

    public static int[] sort(int[] source) {
        return sort(source, SortStrategy.QuickSort);
    }

    public static int[] sort(int[] source, SortStrategy sortStrategy) {
        return sortStrategy.getSorter().sort(source);
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 7, 4, 6, 2, 7, 9, 1, 8, 2, 8, 9, 4, 7};
        System.out.println(Arrays.toString(sort(a, SortStrategy.BubbleSort)));
        System.out.println(Arrays.toString(sort(a, SortStrategy.QuickSort)));
        System.out.println(Arrays.toString(sort(a, SortStrategy.MergeSort)));
    }
}
