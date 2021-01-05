/*
//实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数
//问题。 
//
// 
//
// 示例 1: 
//
// 输入: 2.00000, 10
//输出: 1024.00000
// 
//
// 示例 2: 
//
// 输入: 2.10000, 3
//输出: 9.26100
// 
//
// 示例 3: 
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25 
//
// 
//
// 说明: 
//
// 
// -100.0 < x < 100.0 
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。 
// 
//
// 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/ 
// Related Topics 递归 
// 👍 96 👎 0

*/

package com.inori.swordoffer;

public class $v16_ShuZhiDeZhengShuCiFangLcof {
    public static void main(String[] args) {
        int n = -2147483648;
        System.out.println(-n);
        Solution solution = new $v16_ShuZhiDeZhengShuCiFangLcof().new Solution();
        System.out.println(solution.myPow(2, 2));
    }

    class Solution {

        /**
         * 二进制法：将n转换成二进制表示：b1b2b3...bm，其中bi表示第i位的二进制数，根据二进制转10进制公式可得：
         * n=2^0*b1 + 2^1*b2 + ... + 2^m-1 * bm， 即：
         * x^n = x^(2^0*b1 + 2^1*b2 + ... + 2^m-1 * bm) = x^(2^0*b1) * x^(2^1*b2) *...* x^(2^m-1*bm)
         *
         * @param x
         * @param n
         * @return
         */
        public double myPow(double x, int n) {
            if (x == 0) return 0;
            double res = 1;
            //这里要注意用long来接收b，不然case：n = -2147483648 过不了
            long b = n > 0 ? n : -n;
            if (b < 0) {
                x = 1 / x;
                b = -b;
            }
            while (b > 0) {
                if ((b & 1) == 1) res *= x;
                x *= x;
                b >>= 1;
            }
            return res;
        }

        //傻瓜式做法，超时
        public double myPow1(double x, int n) {
            boolean symbol = n > 0;
            n = Math.abs(n);
            double res = 1;
            for (int i = 0; i < n; i++) {
                res *= x;
            }
            return symbol ? res : 1 / res;
        }
    }

}