/*
//有一个二维矩阵 A 其中每个元素的值为 0 或 1 。 
//
// 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。 
//
// 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。 
//
// 返回尽可能高的分数。 
//
// 
//
// 
// 
//
// 示例： 
//
// 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
//输出：39
//解释：
//转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
//0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 20 
// 1 <= A[0].length <= 20 
// A[i][j] 是 0 或 1 
// 
// Related Topics 贪心算法 
// 👍 110 👎 0

*/

package com.inori.everyday;

import java.util.Arrays;

public class $861_ScoreAfterFlippingMatrix {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.matrixScore(new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}});
        System.out.println(i);
    }

    static class Solution {
        public int matrixScore(int[][] a) {
            for (int i = 0; i < a.length; i++) {
                if (a[i][0] == 0) {
                    for (int j = 0; j < a[i].length; j++) {
                        a[i][j] ^= 1;
                    }
                }
            }
            for (int i = 1; i < a[0].length; i++) {
                int count1 = 0;
                for (int j = 0; j < a.length; j++) {
                    count1 += a[j][i];
                }
                if (count1 < a.length - count1) {
                    for (int j = 0; j < a.length; j++) {
                        a[j][i] ^= 1;
                    }
                }
            }
            int sum = 0;
            for (int i = 0; i < a.length; i++) {
                int value = 0, len = a[i].length;
                for (int j = 0; j < len; j++) {
                    value += (a[i][j] * Math.pow(2, len - 1 - j));
                }
                sum += value;
            }
            return sum;
        }
    }


}