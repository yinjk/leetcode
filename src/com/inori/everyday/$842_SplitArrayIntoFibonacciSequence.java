/*
//给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。 
//
// 形式上，斐波那契式序列是一个非负整数列表 F，且满足： 
//
// 
// 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）； 
// F.length >= 3； 
// 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。 
// 
//
// 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。 
//
// 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。 
//
// 
//
// 示例 1： 
//
// 输入："123456579"
//输出：[123,456,579]
// 
//
// 示例 2： 
//
// 输入: "11235813"
//输出: [1,1,2,3,5,8,13]
// 
//
// 示例 3： 
//
// 输入: "112358130"
//输出: []
//解释: 这项任务无法完成。
// 
//
// 示例 4： 
//
// 输入："0123"
//输出：[]
//解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
// 
//
// 示例 5： 
//
// 输入: "1101111"
//输出: [110, 1, 111]
//解释: 输出 [11,0,11,11] 也同样被接受。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 200 
// 字符串 S 中只含有数字。 
// 
// Related Topics 贪心算法 字符串 回溯算法 
// 👍 141 👎 0

*/

package com.inori.everyday;

import java.util.ArrayList;
import java.util.List;

public class $842_SplitArrayIntoFibonacciSequence {
    public static void main(String[] args) {
        Solution solution = new $842_SplitArrayIntoFibonacciSequence().new Solution();
        System.out.println(solution.splitIntoFibonacci("0123"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> splitIntoFibonacci(String s) {
            List<Integer> res = new ArrayList<>();
            if (backTrack(s, res, 0)) {
                return res;
            }
            return new ArrayList<>();
        }

        boolean backTrack(String s, List<Integer> res, int index) {
            if (index == s.length() && res.size() >= 3) return true;
            long curLong = 0;
            for (int i = index; i < s.length(); i++) {
                if (s.charAt(index) == '0' && i > index) { //数字不能以0开头
                    break;
                }
                curLong = curLong * 10 + (s.charAt(i) - '0');
                if (curLong > Integer.MAX_VALUE) { //数字不能大于32位最大整数
                    break;
                }
                // 前两个数之和已经小于当前数了，此时再增加当前数的值前两个数
                // 之和会一直小于当前数，所以此时跳出循环直接返回false
                if (res.size() >= 2 && (res.get(res.size() - 1) + res.get(res.size() - 2) < curLong)) {
                    break;
                }
                //如果列表小于两个数或则前两个数之和等于当前数，开始寻找下一个数
                if (res.size() < 2 || res.get(res.size() - 1) + res.get(res.size() - 2) == curLong) {
                    res.add((int) curLong);
                    if (backTrack(s, res, i + 1)) {
                        return true;
                    } else {//如果没有找到，在进行下一次循环之前应该把当前的数从列表中移除掉
                        res.remove(res.size() - 1);
                    }
                }

            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}