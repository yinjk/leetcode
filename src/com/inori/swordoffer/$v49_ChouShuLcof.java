/*
//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 数学 
// 👍 92 👎 0

*/

package com.inori.swordoffer;

public class $v49_ChouShuLcof {
    public static void main(String[] args) {
        Solution solution = new $v49_ChouShuLcof().new Solution();
    }

    class Solution {
        /**
         * 动态规划：
         * 状态定义：由于第i个丑数只可能来自于小于i的某个丑数乘以2、3、5，
         * 即 xi = min(xa * 2, xb * 3, xc * 5)，其中a、b、c ∈ [1, i),
         * 设：动态规划列表dp[i] 表示第i个丑数，a,b,c 均为1
         * <p>
         * 状态转移：根据前面的分析可得dp[i] = min{dp[a] * 2, dp[b] * 3， dp[c] * 5},
         * 并且令到达dp[i]的（a、b、c） + 1，即判断满足dp[i] = min{dp[a] * 2, dp[b] * 3， dp[c] * 5}
         * 这个条件的(a、b、c)+1
         *
         * @param n 求第n个丑数
         * @return 第n个丑数
         */
        public int nthUglyNumber(int n) {
            int[] dp = new int[n];
            int a = 0, b = 0, c = 0;
            dp[0] = 1;
            for (int i = 1; i < n; i++) {
                int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
                int dpi = Math.min(Math.min(n2, n3), n5);
                dp[i] = dpi;
                if (dpi == n2) a++;
                if (dpi == n3) b++;
                if (dpi == n5) c++;
            }
            return dp[n - 1];
        }
    }


}