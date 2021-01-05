/*
//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 
// 👍 83 👎 0

*/

package com.inori.everyday.leetcode.editor.cn;

public class $53_I_ZaiPaiXuShuZuZhongChaZhaoShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new $53_I_ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
        int search = solution.search(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(search);
    }

    class Solution {
        public int search(int[] nums, int target) {
            int i = 0, j = nums.length - 1;
            //寻找右边界
            while (i <= j) {
                int mid = i + (j - i) / 2;
                if (nums[mid] <= target) { //注意：这里的等于是为了找到右边界
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
            int right = i;
            if (right > 0 && nums[right - 1] != target) return 0;
            //寻找左边界
            i = 0;
            j = nums.length - 1;
            while (i <= j) {
                int mid = i + (j - i) / 2;
                if (nums[mid] >= target) { //注意：这里的等于是为了找到左边界
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            }
            int left = j;
            return right - left - 1;
        }
    }

}