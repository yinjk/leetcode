package com.inori.swordoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * $v3_FindRepeatNumber [Easy]
 * 找出数组中重复的数字。
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * <p>
 * <p>
 * 限制：
 * <p>
 * 2 <= n <= 100000
 *
 * @author inori
 * @date 2020/3/21
 */
public class $v3_FindRepeatNumber {

    /**
     * 暴力求解，不解释
     * @param nums 输入数组
     * @return 重复数
     */
    public int findRepeatNumber(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) return num;
            map.put(num, true);
        }
        return -1;
    }

    public int findRepeatNumber1(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) return num;
            map.put(num, true);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new $v3_FindRepeatNumber().findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
}
