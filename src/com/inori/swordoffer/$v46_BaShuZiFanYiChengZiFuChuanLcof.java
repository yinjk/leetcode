/*
//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 122 58有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
//
// 
//
// 提示： 
//
// 
// 0 <= num < 231 
// 
// 👍 162 👎 0

*/

package com.inori.swordoffer;

public class $v46_BaShuZiFanYiChengZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new $v46_BaShuZiFanYiChengZiFuChuanLcof().new Solution();
        System.out.println(solution.translateNum(18822));
    }

    class Solution {
        /**
         * 动态规划，初始状态： f(0) = 1, f(1) = 1, f(2) = 2 || 1
         * 转移方程：f(n) = f(n-1) + f(n-2), 注意，这里在计算f(n-2)时要判断最后两位：
         * 1. 第一位是否为0，2.两位数是否小于26， 需要同时满足这两个条件才能计算f(n-2)，
         * 否则f(n-2) = 0
         *
         * @param num
         * @return
         */
        public int translateNum(int num) {
            char[] chars = Integer.toString(num).toCharArray();
            if (chars.length < 2) return 1;
            int f1 = 1, f2 = 1, cur = f2;// 设 f(i-2) = f1, f(i-1) = f2
            for (int i = 1; i < chars.length; i++) {
                //这种情况下i-1和i两个字符一起无法翻译，所以此时 f(i) = f(i-1),直接跳过
                if (chars[i - 1] == '1' || chars[i - 1] == '2' && chars[i] <= '5') {
                    cur = f1 + f2;
                }
                f1 = f2;
                f2 = cur;
            }
            return cur;
        }
    }


}