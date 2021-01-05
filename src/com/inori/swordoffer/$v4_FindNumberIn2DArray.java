package com.inori.swordoffer;

/**
 * $v4_FindNumberIn2DArray [Easy]
 * <p>
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 * <p>
 * 限制：
 * <p>
 * 0 <= n <= 1000
 * <p>
 * 0 <= m <= 1000
 * <p>
 * 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 *
 * @author inori
 * @date 2020/3/21
 */
public class $v4_FindNumberIn2DArray {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int[] m : matrix) {
            if (m.length == 0) return false;
            int min = m[0];
            int max = m[m.length - 1];
            if (target < min || target > max) {
                continue;
            }
            if (binarySearch(m, target) != -1) {
                return true;
            }
        }
        return false;

    }

    /**
     * 二分查找，若找到返回对应的下标，若没找到，返回-1
     *
     * @param nums   查找的数组
     * @param target 需要查找的数
     * @return 查找的数组下标
     */
    public int binarySearch(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }


    public int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = right + left / 2;
        if (nums[mid] == target) return mid;
        else if (target > nums[mid]) return binarySearch(nums, mid + 1, right, target);
        else return binarySearch(nums, left, mid - 1, target);
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(new $v4_FindNumberIn2DArray().findNumberIn2DArray(a, 20));

    }


}
