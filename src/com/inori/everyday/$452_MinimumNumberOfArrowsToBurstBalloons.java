package com.inori.everyday;

import com.inori.util.ArraysUtil;

import java.util.Arrays;
import java.util.Comparator;

/**
 * $452_MinimumNumberOfArrowsToBurstBalloons
 *
 * @author inori
 * @date 2020/11/23
 */
public class $452_MinimumNumberOfArrowsToBurstBalloons {

    public static void main(String[] args) {
        int[][] points = new int[][]{{0, 9}, {1, 8}, {7, 8}, {1, 6}, {9, 16}, {7, 13}, {7, 10}, {6, 11}, {6, 9}, {9, 13}};
        int minArrowShots = findMinArrowShots(points);
        System.out.println(minArrowShots);
    }

    /**
     * 按右边界值排序 复杂度：19 ms	46.2 MB
     * 完美
     *
     * @param points
     * @return
     */
    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, Comparator.comparingInt(p -> p[1]));
        int res = 1;
        int pre = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > pre) {
                res++;
                pre = points[i][1];
            }
        }
        return res;

    }

    /**
     * 按左边界值排序，复杂度： 150 ms	47 MB
     * 又蠢又傻又low
     *
     * @param points
     * @return
     */
    private static int findMinArrowShots1(int[][] points) {
        if (points.length == 0) return 0;
        sort(points, 0, points.length - 1);
        int result = 1;
        for (int i = 0; i < points.length; ) { //right
            int minRight = points[i][1];
            boolean isFire = false;
            for (int j = i + 1; j < points.length; j++) { //left
                if (minRight > points[j][1]) minRight = points[j][1];
                if (points[j][0] > minRight) { //fire
                    result++;
                    isFire = true;
                    i = j;
                    break;
                }
            }
            if (!isFire) {
                i++;
            }
        }
        return result;
    }

    public static void sort(int[][] a, int low, int high) {
        int i, j;
        int[] index;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        index = a[i]; // 用子表的第一个记录做基准
        while (i < j) { // 从表的两端交替向中间扫描
            while (i < j && a[j][0] >= index[0])
                j--;
            if (i < j)
                a[i++] = a[j];// 用比基准小的记录替换低位记录
            while (i < j && a[i][0] < index[0])
                i++;
            if (i < j) // 用比基准大的记录替换高位记录
                a[j--] = a[i];
        }
        a[i] = index;// 将基准数值替换回 a[i]
        sort(a, low, i - 1); // 对低子表进行递归排序
        sort(a, i + 1, high); // 对高子表进行递归排序
    }

}
