package com.inori.util.sort;

/**
 * BubbleSort
 * 冒泡排序，最直观，最原始，也是时间复杂度最高的一种排序算法
 * 时间复杂度：O(n^2)，空间复杂度：O(1)
 *
 * @author inori
 * @date 2020/12/3
 */
public class BubbleSort implements Sorter {
    @Override
    public int[] sort(int[] source) {
        for (int i = source.length; i > 1; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (source[j] > source[j + 1]) {
                    int tmp = source[j];
                    source[j] = source[j + 1];
                    source[j + 1] = tmp;
                }
            }
        }
        return source;
    }

}
