package com.inori.util.sort;

/**
 * MergeSort
 * 归并排序，也是利用分治的思想，将大数组拆分成小数组，
 * 再将小数组拆分成更小的数组，直到不能拆分，
 * 最后再将左右两个数组通过插入排序放进新数组，如此递归，即可完成排序，
 * 由于需要拆分log n次层，每层需要循环n次，所以时间复杂度为O(nlogn)
 * <p>
 * 时间复杂度：O(nlogn)，空间复杂度：O(n)
 *
 * @author inori
 * @date 2020/12/3
 */
public class MergeSort implements Sorter {
    @Override
    public int[] sort(int[] source) {
        return mergeSort(source, 0, source.length - 1);
    }

    private int[] mergeSort(int[] source, int left, int right) {
        if (left == right) {
            return new int[]{source[right]};
        }
        int mid = left + (right - left) / 2;
        int[] leftArray = mergeSort(source, left, mid);
        int[] rightArray = mergeSort(source, mid + 1, right);
        return merge(leftArray, rightArray);
    }

    private int[] merge(int[] left, int[] right) {
        int i = 0, j = 0;
        int[] res = new int[left.length + right.length];
        while (i < left.length || j < right.length) {
            res[i + j] = (i < left.length && j < right.length && left[i] < right[j]) || i < left.length && j >= right.length ? left[i++] : right[j++];
        }
        return res;
    }
}
