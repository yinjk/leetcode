package com.inori.swordoffer;

/**
 * $10_I_FeiBoNaQiShuLieLcof
 *
 * @author inori
 * @date 2020/11/24
 */
public class $v10_I_FeiBoNaQiShuLieLcof {
    public static void main(String[] args) {
        System.out.println(new $v10_I_FeiBoNaQiShuLieLcof().fib(5));
    }

    public int fib(int n) {
        if (n == 0) return 0;
        int n2 = 0;
        int n1 = 1;
        int cur = n1;
        for (int i = 2; i <= n; i++) {
            cur = (n1 + n2) % 1000000007;
            n2 = n1;
            n1 = cur;
        }
        return cur;
    }

    /**
     * 直接递归，大量重复运算，超时
     *
     * @param n
     * @return
     */
    public int fib1(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib1(n - 1) + fib1(n - 2) % 1000000007;
    }


}
