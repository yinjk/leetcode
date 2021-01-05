package com.inori.interview;

/**
 * $7_ReverseInteger [Easy]
 *
 * <p>
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author inori
 * @date 2020/3/7
 */
public class $7_ReverseInteger {

    public int reverse(int x) {
        int reverse = 0;
        while (x != 0) {
            int tmp = reverse;
            reverse = reverse * 10 + x % 10;
            if (reverse / 10 != tmp) { //判断是否溢出
                return 0;
            }
            x = x / 10;
        }
        return reverse;
    }

    public static void main(String[] args) {
        int a = 1534236461;
        System.out.println(new $7_ReverseInteger().reverse(a));

    }

}
