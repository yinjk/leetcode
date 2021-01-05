/*
//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 回溯算法 
// 👍 146 👎 0

*/

package com.inori.swordoffer;

import java.util.HashSet;
import java.util.LinkedList;

public class $v38_ZiFuChuanDePaiLieLcof {
    public static void main(String[] args) {
        Solution solution = new $v38_ZiFuChuanDePaiLieLcof().new Solution();
        solution.permutation("");
    }

    class Solution {
        LinkedList<String> res = new LinkedList<>();
        char[] chars;

        /**
         * 参考题解：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/solution/mian-shi-ti-38-zi-fu-chuan-de-pai-lie-hui-su-fa-by/
         * @param s arg
         * @return return
         */
        public String[] permutation(String s) {
            chars = s.toCharArray();
            dfs(0);
            return res.toArray(new String[0]);
        }

        void dfs(int x) {
            if (x == chars.length) {
                res.add(String.valueOf(chars));
                return;
            }
            HashSet<Character> set = new HashSet<>();
            for (int i = x; i < chars.length; i++) {
                if (set.contains(chars[i])) continue; //重复的需要剪枝，直接跳过
                swap(i, x);
                dfs(x + 1);
                swap(i, x);
                set.add(chars[i]);
            }
        }

        void swap(int i, int j) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
    }

}