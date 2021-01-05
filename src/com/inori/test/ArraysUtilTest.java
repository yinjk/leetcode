package com.inori.test;

import com.inori.util.ArraysUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * ArraysUtilTest
 *
 * @author inori
 * @date 2020/3/23
 */
public class ArraysUtilTest {

    @Test
    public void testMergeSort() {
        int[] a = {7, 3, 4, 10, 9, 6, 7, 8};
        ArraysUtil.mergeSort(a);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(ArraysUtil.mergeSortWithReturn(new int[]{7, 3, 4, 10, 9, 6, 7, 8})));
    }

    @Test
    public void testBinarySearch() {
        System.out.println(ArraysUtil.binarySearch(new int[]{1, 2, 4, 5, 6, 7, 9, 10}, 7));
    }

}
