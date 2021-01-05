/*
//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。 
//
// 
//
// 示例： 
//
// 输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// 1 <= nums[i] <= 10000 
// 
// 👍 62 👎 0

*/

package com.inori.swordoffer;

import java.util.Arrays;

public class $v21_DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof {
    public static void main(String[] args) {
        Solution solution = new $v21_DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
        System.out.println(Arrays.toString(solution.exchange(new int[]{8, 10, 3, 20, 12, 4, 10, 8, 4, 0, 5, 17, 7, 20, 3})));

    }

    class Solution {

        //稍微优雅一点的代码
        public int[] exchange(int[] nums) {
            int i = 0, j = nums.length - 1;
            while (i < j) {
                if ((nums[i] & 1) == 1) { //从前往后找到第一个偶数
                    i++;
                    continue;
                }
                if ((nums[j] & 1) == 0) { //从后往前找到第一个奇数
                    j--;
                    continue;
                }
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
            return nums;
        }

        //丑陋的代码
        public int[] exchange1(int[] nums) {
            int j = nums.length - 1;
            for (int i = 0; i < j; i++) {
                if ((nums[i] & 1) == 0) { //偶数放后面
                    while ((nums[j] & 1) == 0) {//从后面向前面找第一个奇数
                        if (j <= i) return nums;
                        j--;
                    }
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
            return nums;
        }
    }


}