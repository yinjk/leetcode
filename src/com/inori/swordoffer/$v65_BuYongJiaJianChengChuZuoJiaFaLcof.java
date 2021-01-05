/*
//写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。 
//
// 
//
// 示例: 
//
// 输入: a = 1, b = 1
//输出: 2 
//
// 
//
// 提示： 
//
// 
// a, b 均可能是负数或 0 
// 结果不会溢出 32 位整数 
// 
// 👍 100 👎 0

*/

package com.inori.swordoffer;

public class $v65_BuYongJiaJianChengChuZuoJiaFaLcof {
    public static void main(String[] args) {
        Solution solution = new $v65_BuYongJiaJianChengChuZuoJiaFaLcof().new Solution();
        solution.add(-1, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int add(int a, int b) {
            int res = 0, ret = 0, i = 0;
            for (; a != 0 || b != 0; i++) {
                if (((a & 1) & (b & 1)) == 1) {
                    if (ret == 1) {
                        res |= (1 << i);
                    }
                    ret = 1;
                } else if ((((a & 1) | (b & 1)) == 1) && ret == 1) {
                    res &= ~(1 << i);
                    ret = 1;
                } else {
                    res |= (((a & 1) | (b & 1) | ret) << i);
                    ret = 0;
                }
                a >>= 1;
                b >>= 1;
            }
            if (ret != 0) res |= 1 << i;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}