package com.inori.interview;

/**
 * $4_MedianOfTwoSortedArrays [Hard]
 * <p>
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author inori
 * @date 2020/3/6
 */
public class $4_MedianOfTwoSortedArrays {

    /**
     * 时间复杂度： O(m+n), 空间复杂度 O(m+n)
     *
     * @param nums1 arrays 1
     * @param nums2 arrays 2
     * @return the median of two arrays
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i1 = 0; //第一个数组的起始下标
        int i2 = 0; //第二个数组的起始下标
        int i = 0;
        int m = nums1.length;
        int n = nums2.length;
        int[] marge = new int[m + n];
        //将两个数组合并，由于两个数组都是有序的，所以可以采用如下方式合并
        while (i1 < m || i2 < n) {
            if (i1 < m && i2 < n) {
                if (nums1[i1] < nums2[i2]) {
                    marge[i++] = nums1[i1];
                    i1++;
                } else {
                    marge[i++] = nums2[i2];
                    i2++;
                }
            } else {
                marge[i++] = i1 < m ? nums1[i1++] : nums2[i2++];
            }
        }
        //求中位数
        int median = (m + n) / 2;
        if ((m + n) % 2 == 0) {
            return (marge[median - 1] + marge[median]) / 2.0;
        }
        return marge[median];
    }

    /**
     * 时间复杂度： O(m+n), 空间复杂度 O(1)
     * //TODO: 不真实合并两个数组，通过在两个数组中移动i和j直接找出中位数，并返回。
     *
     * @param nums1 arrays 1
     * @param nums2 arrays 2
     * @return the median of two arrays
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        return 1;
    }
    /**
     * 时间复杂度： O(m+n), 空间复杂度 O(1)
     *
     * 官方解法：递归二分法
     * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xun-zhao-liang-ge-you-xu-shu-zu-de-zhong-wei-shu-b/
     *
     * @param nums1 arrays 1
     * @param nums2 arrays 2
     * @return the median of two arrays
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        return 1;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 8, 9};
        int[] nums2 = new int[]{3, 5, 6};
        System.out.println(new $4_MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2));
    }
}
