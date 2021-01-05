/*
//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。 
//
// 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: "102" 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: "3033459" 
//
// 
//
// 提示: 
//
// 
// 0 < nums.length <= 100 
// 
//
// 说明: 
//
// 
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数 
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
// Related Topics 排序 
// 👍 132 👎 0

*/

package com.inori.swordoffer;

import com.inori.util.sort.SortStrategy;
import com.inori.util.sort.SortUtils;
import com.inori.util.sort.Sorter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntConsumer;

public class $v45_BaShuZuPaiChengZuiXiaoDeShuLcof {
    public static void main(String[] args) {
        Solution solution = new $v45_BaShuZuPaiChengZuiXiaoDeShuLcof().new Solution();
        System.out.println(solution.minNumber(new int[]{824, 938, 1399, 5607, 6973, 5703, 9609, 4398, 8247}));
    }

    class Solution {
        public String minNumber(int[] nums) {
            sort(nums, 0, nums.length - 1);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nums.length; i++) {
                sb.append(nums[i]);
            }
            return sb.toString();
        }

        void sort(int[] nums, int left, int right) {
            if (left > right) {
                return;
            }
            int i = left, j = right;
            while (i < j) {
                if (!less(nums[j], nums[left])) {
                    j--;
                    continue;
                }
                if (less(nums[i], nums[left])) {
                    i++;
                    continue;
                }
                swap(nums, i, j);
            }
            swap(nums, left, j);
            sort(nums, left, i - 1);
            sort(nums, i + 1, right);
        }

        boolean less(int a, int b) {
            String strA = Integer.toString(a);
            String strB = Integer.toString(b);
            return (strA + strB).compareTo(strB + strA) <=0;
        }

        void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }


}