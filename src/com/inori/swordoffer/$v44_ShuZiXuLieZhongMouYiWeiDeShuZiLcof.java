/*
//数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，
//等等。 
//
// 请写一个函数，求任意第n位对应的数字。 
//
// 
//
// 示例 1： 
//
// 输入：n = 3
//输出：3
// 
//
// 示例 2： 
//
// 输入：n = 11
//输出：0 
//
// 
//
// 限制： 
//
// 
// 0 <= n < 2^31 
// 
//
// 注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/ 
// Related Topics 数学 
// 👍 78 👎 0

*/

package com.inori.swordoffer;

public class $v44_ShuZiXuLieZhongMouYiWeiDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new $v44_ShuZiXuLieZhongMouYiWeiDeShuZiLcof().new Solution();
        System.out.println(solution.findNthDigit(100));
    }

    class Solution {
        /**
         * 1. 先找n对应的数字的位数
         * 2. 再找n对应的数字
         * 3. 最后找n对应的数字的数位
         *
         * @param n
         * @return
         */
        public int findNthDigit(int n) {
            int i = 1; //1. n对应的数字的位数
            long start = 1;
            long count = 9;
            while (n > count) { // 1.
                n -= count;
                i += 1;
                start *= 10;
                count = i * start * 9;
            }
            //2. 找到n对应的数字
            long num = start + (n - 1) / i;
            //3. 找到n对应的数字的位数
            return Long.toString(num).charAt((n - 1) % i) - '0';

        }
    }


}