package com.inori.interview;

/**
 * $153_FindMin [Hard]
 * <p>
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 请找出其中最小的元素。
 * <p>
 * 注意数组中可能存在重复的元素。
 * <p>
 * 示例 1：
 * <p>
 * 输入: [1,3,5]
 * 输出: 1
 * 示例 2：
 * <p>
 * 输入: [2,2,2,0,1]
 * 输出: 0
 * 说明：
 * <p>
 * 这道题是 寻找旋转排序数组中的最小值 的延伸题目。
 * 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
 *
 * @author inori
 * @date 2020/3/19
 */
public class $154_FindMin_II {

    /**
     * 二分法求解，和I不一样之处在于数组元素可重复，那么当nums[mid]==nums[0]时无法判断该向左搜索还是该向右搜索比如：
     * [1,1,1,1,1,0,1] [1,0,1,1,1,1,1]，这两个数组的num[mid]和num[0]都为1，但是最小值既可能在左边又可能在右边，所以无法判断该向左还是向右搜索，这也是该题的难点
     * <p>
     * 精选题解：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/solution/154-find-minimum-in-rotated-sorted-array-ii-by-jyd/
     * 时间复杂度O(logN),极端情况下O(N)
     *
     * @param nums 输入数组
     * @return 数组的最小值
     */
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int middle = (right + left) >> 1;
            //如果当前值比最后一个元素小，当前值在第二个数组，最小值在left和当前值中间，故向左搜索
            if (nums[middle] < nums[right]) right = middle;
            //如果当前值比最后一个元素大，当前值在第一个数组，最小值在当前值和right中间，故向右搜索
            else if (nums[middle] > nums[right]) left = middle + 1;
            //如果当前值等于最后一个元素，将right减一，可证明：1.right不会越界（因为while条件0<=left<right,即right>=1）2.最小值不会丢失（应为middle<right且nums[middle] == nums[right]）
            else if (nums[middle] == nums[right]) right--;
        }
        return nums[left];
    }


    public static void main(String[] args) {
        System.out.println(new $154_FindMin_II().findMin(new int[]{3, 1, 3}));
    }
}
