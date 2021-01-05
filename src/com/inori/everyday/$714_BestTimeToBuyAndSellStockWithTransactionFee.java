/*
//给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。 
//
// 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。 
//
// 返回获得利润的最大值。 
//
// 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。 
//
// 示例 1: 
//
// 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
//输出: 8
//解释: 能够达到的最大利润:  
//在此处买入 prices[0] = 1
//在此处卖出 prices[3] = 8
//在此处买入 prices[4] = 4
//在此处卖出 prices[5] = 9
//总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8. 
//
// 注意: 
//
// 
// 0 < prices.length <= 50000. 
// 0 < prices[i] < 50000. 
// 0 <= fee < 50000. 
// 
// Related Topics 贪心算法 数组 动态规划 
// 👍 339 👎 0

*/

package com.inori.everyday;

public class $714_BestTimeToBuyAndSellStockWithTransactionFee {
    public static void main(String[] args) {
        Solution solution = new $714_BestTimeToBuyAndSellStockWithTransactionFee().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 动态规划，
         * 状态定义：设定动态规划数组dp[n][2], 其中dp[i][0]表示第i天手里没有股票的最大收益，
         * dp[i][1]表示第i天手里有股票的最大收益。
         * 状态转移：
         * 1. 假如第i天手里没有股票（即dp[i][0]），可能是第i-1天手里就没有股票（此时dp[i][0] = dp[i-1][0]），
         * 或则第i-1天手里有股票，但第i天将股票卖了(此时dp[i][0] = dp[i-1][1] + prices[i] -fee)，所以
         * 为了收益最大化，dp[i][0] = max{dp[i-1][0],dp[i-1][1]+prices[i]-fee}
         * <p>
         * 2. 假如第i天手里有股票（即dp[i][1]），则该状态可能是以下两种状态转移来的：第i-1天手里就有股票今天没卖，
         * 第i-1天手里没有股票今天买了。同理可得出dp[i][1]= max{dp[i][1], dp[i][0]-prices[i]} 注意：题目
         * 中有说明：每次交易从买入到卖出只用支付一次手续费，所以我们在情况1（即卖出时）已经交过手续费了，故在买
         * 入时就不用交手续费了，所以这里没有再减fee了。
         * <p>
         * 结论：一直遍历数组，最后取max{dp[n-1][0], dp[n-1][1]}就是最大收益了。
         * <p>
         * 时间复杂度：O(N)，空间复杂度：O(N)
         * <p>
         * 优化： 由于我们状态转移过程中只会用到dp[n-1]的状态，故可以将dp数组优化成两个变量dp0,dp1分别用来表示：
         * dp[i-1][0]和dp[i-1][1]，以此可以将空间复杂度优化到O(1).
         *
         * @param prices 每日股价
         * @param fee    交易手续费
         * @return 最大收益
         */
        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;
            int[][] dp = new int[n][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return Math.max(dp[n - 1][0], dp[n - 1][1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}