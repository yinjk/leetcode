/*
//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 
//
// 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/ 
//
// 
// Related Topics 位运算 分治算法 
// 👍 95 👎 0

*/

package com.inori.swordoffer;

public class $v39_ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new $v39_ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof().new Solution();
    }

    class Solution {
        /**
         * 摩尔投票法：既然某个数超过了数组的一半，当出现这个数时，count+1，当不是这个数时，count-1，最后这个数的count一定大于0
         * 时间复杂度：O(N) 空间复杂度：O(1)
         *
         * @param nums 输入数组
         * @return 众数
         */
        public int majorityElement(int[] nums) {
            int x = 0, votes = 0;
            for (int i = 0; i < nums.length; i++) {
                if (votes == 0) x = nums[i];
                votes += x == nums[i] ? 1 : -1;
            }
            return x;
        }
    }


}