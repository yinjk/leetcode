/*
//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 示例 1： 
//
// 输入：n = 2
//输出：2
// 
//
// 示例 2： 
//
// 输入：n = 7
//输出：21
// 
//
// 示例 3： 
//
// 输入：n = 0
//输出：1 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/ 
//
// 
// Related Topics 递归 
// 👍 90 👎 0

*/

package com.inori.swordoffer;

public class $v10_II_QingWaTiaoTaiJieWenTiLcof {
    public static void main(String[] args) {
        Solution solution = new $v10_II_QingWaTiaoTaiJieWenTiLcof().new Solution();
        System.out.println(solution.numWays(2));
    }

    class Solution {


        // 常规做法
        public int numWays(int n) {
            int n_1 = 1;
            int n_2 = 2;
            int res = n_1;
            for (int i = 2; i < n; i++) {
                res = (n_1 + n_2) % 1000000007;
                n_1 = n_2;
                n_2 = res;
            }
            return res;
        }
    }


}