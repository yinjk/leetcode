/*
//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。 
//
// 要求时间复杂度为O(n)。 
//
// 
//
// 示例1: 
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -100 <= arr[i] <= 100 
// 
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/ 
//
// 
// Related Topics 分治算法 动态规划 
// 👍 175 👎 0

*/

package com.inori.swordoffer;

public class $v42_LianXuZiShuZuDeZuiDaHeLcof {
    public static void main(String[] args) {
        Solution solution = new $v42_LianXuZiShuZuDeZuiDaHeLcof().new Solution();
        System.out.println(solution.maxSubArray(new int[]{1, 2}));
    }

    class Solution {
        public int maxSubArray(int[] nums) {
            int res = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i - 1] > 0) { //若dp[i-1] 大于0，则认为dp[i-1]对dp[i]产生正影响，否则认为其对dp[i]产生负影响
                    nums[i] += nums[i - 1];
                }
                res = Math.max(nums[i], res);
            }
            return res;
        }
    }


}