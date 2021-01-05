package com.inori.interview;

/**
 * $9_PalindromeNumber [Easy]
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author inori
 * @date 2020/3/7
 */
public class $9_PalindromeNumber {

    /**
     * 虽然可以不用处理反转数字的溢出问题（因为溢出一定不是回文，溢出之后与原数字也不等），但是如果只反转一半的话，时间复杂度会节约一半
     * 参考：https://leetcode-cn.com/problems/palindrome-number/solution/hui-wen-shu-by-leetcode/ 【官方】
     *
     * @param x the number
     * @return is palindrome number
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int tmp = x;
        int p = 0;
        while (tmp != 0) {
            p = p * 10 + tmp % 10;
            tmp = tmp / 10;
        }
        return p == x;
    }

    public static void main(String[] args) {
        int a = 1221;
        System.out.println(new $9_PalindromeNumber().isPalindrome(a));
    }
}
