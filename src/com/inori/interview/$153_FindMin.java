package com.inori.interview;

/**
 * $153_FindMin [Medium]
 * <p>
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 请找出其中最小的元素。
 * <p>
 * 你可以假设数组中不存在重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 *
 * @author inori
 * @date 2020/3/19
 */
public class $153_FindMin {

    /**
     * 暴力求解法，循环找到下降值，无情 不解释
     *
     * @param nums 输入数组
     * @return 数组的最小值
     */
    public int findMin(int[] nums) {
        int min = nums[0];
        for (int num : nums) {
            if (num < min) {
                return num;
            }
        }
        return min;
    }

    /**
     * 二分法求解，由于二分法要求数组有序，而我们的数组可能被旋转过，变成两部分有序，故需要改进一下二分算法的判断逻辑。
     * 如果二分查找的元素大于数组的第一个元素，那么应该搜索右边,反之应该搜索左边
     * 见官方题解：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/solution/xun-zhao-xuan-zhuan-pai-lie-shu-zu-zhong-de-zui-xi/
     *
     * @param nums 输入数组
     * @return 数组的最小值
     */
    public int findMin2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1;
        //如果第一个元素比最后一个元素小说明没有旋转过（只要发生过旋转，那么第一个元素一定比最后一个元素大），直接返回第一个元素
        if (nums[0] < nums[right]) {
            return nums[0];
        }
        while (left < right) {
            int middle = (right + left) / 2;
            if (nums[middle] > nums[middle + 1]) {
                return nums[middle + 1];
            }
            if (nums[middle - 1] > nums[middle]) {
                return nums[middle];
            }
            //如果当前值比第一个元素小，说明应该向左搜索
            if (nums[middle] < nums[0]) {
                right = middle - 1;
            }
            //如果当前值比第一个元素大，说明应该向右搜索
            if (nums[middle] > nums[0]) {
                left = middle + 1;
            }
        }
        return nums[0];
    }


    public static void main(String[] args) {
        System.out.println(new $153_FindMin().findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(new $153_FindMin().findMin2(new int[]{3, 4, 5, 6, 7, 0, 1, 2}));
    }
}
