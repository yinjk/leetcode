package com.inori.everyday;

import java.util.Arrays;

/**
 * $v40_LeastNumbers
 *
 * @author inori
 * @date 2020/3/20
 */
public class $v40_LeastNumbers {

    /**
     * 暴力解法，不解释
     * @param arr 输入数组
     * @param k 输出的个数
     * @return 结果集
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            int min = arr[0];
            int index = 0;
            for (int j = 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    index = j;
                    min = arr[j];
                }
            }
            arr[index] = Integer.MAX_VALUE;
            res[i] = min;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new $v40_LeastNumbers().getLeastNumbers(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4)));
    }
}
