/*
//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 例如，上图是一个7 x 3 的网格。有多少可能的路径？ 
//
// 
//
// 示例 1: 
//
// 输入: m = 3, n = 2
//输出: 3
//解释:
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向右 -> 向下
//2. 向右 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向右
// 
//
// 示例 2: 
//
// 输入: m = 7, n = 3
//输出: 28 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 10 ^ 9 
// 
// Related Topics 数组 动态规划 
// 👍 787 👎 0

*/

package com.inori.everyday;

public class $62_UniquePaths {
    public static void main(String[] args) {
        Solution solution = new $62_UniquePaths().new Solution();
        System.out.println(solution.uniquePaths(7, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 动态规划, 转移方程：f(i,j) = f(i-1, j) + f(i,j-1)
         * 特殊处理：当i = 0或j = 0, f(i,j) = 1
         * 时间复杂度：O(mn) 空间复杂度O(mn)
         *
         * @param m 行
         * @param n 列
         * @return 路径数
         */
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 || j == 0) dp[i][j] = 1;
                    else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[m - 1][n - 1];
        }

        /**
         * 暴力求解，超出时间限制。 时间复杂度：O((mn)^2) 空间复杂度 O(1)
         *
         * @param m 边界
         * @param n 边界
         * @param i 当前i
         * @param j 当前j
         * @return 路径数量
         */
        public int uniquePaths(int m, int n, int i, int j) {
            if (i == m - 1 && j == n - 1) return 1;
            int result = 0;
            if (i < m - 1) result += uniquePaths(m, n, i + 1, j);
            if (j < n - 1) result += uniquePaths(m, n, i, j + 1);
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}