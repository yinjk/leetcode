package com.inori.swordoffer;

/**
 * $51_ReversePairs [Hard]
 * <p>
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,5,6,4]
 * 输出: 5
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 50000
 *
 * @author inori
 * @date 2020/3/19
 */
public class $v51_ReversePairs {

    /**
     * 暴力求解，无情 不解释 时间复杂度O(n^2)，当然结果自然是超出时间限制
     *
     * @param nums 输入数组
     * @return 逆序对
     */
    public int reversePairs1(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) count++;
            }
        }
        return count;
    }

    /**
     * 使用归并排序的方法求解，时间复杂度O(nlogn)，其主要思路为，在合并左右数组的时候，
     * 如果左数组下标i位置的值大于右数组的值，那么左数组中剩余的所有元素都大于右数组的当前值，
     * 因为左数组是从小到大有序排列的，这样一次性就可以计算出很多逆序对。（这种方式非常巧妙，我一开始是完全没有想到）
     * <p>
     * 题解：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/bao-li-jie-fa-fen-zhi-si-xiang-shu-zhuang-shu-zu-b/
     *
     * @param nums 输入数组
     * @return 逆序对
     */
    public int reversePairs(int[] nums) {
        return reversePairs(nums, 0, nums.length - 1);
    }

    public int reversePairs(int[] nums, int left, int right) {
        if (left < right) {
            int mid = (left + right) >> 1;
            int leftPairs = reversePairs(nums, left, mid); //递归左数组
            int rightPairs = reversePairs(nums, mid + 1, right); // 递归右数组
            //合并左右数组
            int i = left;
            int j = mid + 1;
            int[] tmp = new int[right - left + 1];
            int k = 0;
            int thisPairs = 0;
            while (i <= mid || j <= right) {
                if (i > mid) {
                    tmp[k++] = nums[j++];
                    continue;
                }
                if (j > right) {
                    tmp[k++] = nums[i++];
                    continue;
                }
                if (nums[i] <= nums[j]) {
                    tmp[k++] = nums[i++];
                } else {
                    tmp[k++] = nums[j++];
                    thisPairs += (mid - i + 1);
                }
//                tmp[k++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
            }
            for (int a : tmp) {
                nums[left++] = a;
            }
            return leftPairs + rightPairs + thisPairs;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new $v51_ReversePairs().reversePairs1(new int[]{7, 5, 6, 4}));
        System.out.println(new $v51_ReversePairs().reversePairs(new int[]{7, 5, 6, 4}));
    }
}
