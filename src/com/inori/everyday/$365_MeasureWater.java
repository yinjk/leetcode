package com.inori.everyday;

/**
 * $365_MeasureWater [Medium]
 * <p>
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 * <p>
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 * <p>
 * 你允许：
 * <p>
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * 示例 1: (From the famous "Die Hard" example)
 * <p>
 * 输入: x = 3, y = 5, z = 4
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: x = 2, y = 6, z = 5
 * 输出: False
 *
 * @author inori
 * @date 2020/3/21
 */
public class $365_MeasureWater {

    /**
     * 数学解法，感觉智商被按在了地上摩擦
     * 官方题解：https://leetcode-cn.com/problems/water-and-jug-problem/solution/shui-hu-wen-ti-by-leetcode-solution/
     *
     * @param x 水壶1
     * @param y 水壶2
     * @param z 预期值
     * @return 是否能得到预期值
     */
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) return false;
        if (x == 0 || y == 0) return z == 0 || z == x + y;
        return z % gcd(x, y) == 0;
    }

    public long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a % b);
    }


    public static void main(String[] args) {
        System.out.println(new $365_MeasureWater().canMeasureWater(3, 5, 4));
        System.out.println(new $365_MeasureWater().canMeasureWater(2, 6, 5));
    }
}
