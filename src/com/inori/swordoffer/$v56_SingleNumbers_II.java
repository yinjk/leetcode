package com.inori.swordoffer;

import java.util.Arrays;

/**
 * $v56_SingleNumbers
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,3,3]
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= nums.length <= 10000
 * 1 <= nums[i] < 2^31
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author inori
 * @date 2020/4/28
 */
public class $v56_SingleNumbers_II {

    public int singleNumbers(int[] nums) {
        int r = 0;
        for (int num : nums) {
            r ^= num;
        }
        int div = 1;
        while ((r & div) == 0) {
            div <<= 1;
        }
        int r1 = 0, r2 = 0;
        for (int num : nums) {
            if ((num & div) == 0) r1 ^= num;
            else r2 ^= num;
        }
        return r1 == 0 ? r2 : r1;
    }

    public static void main(String[] args) {
        int[] req = new int[]{9, 1, 7, 9, 7, 9, 7};
        System.out.println(new $v56_SingleNumbers_II().singleNumbers(req));
        double a = 0.32;
        double v = a * 100;
        int count = 0;
        for (int i = 0; i < 200; i++) {
            String s = i + "";
            if (i % 100 < v) {
                count++;
            }
        }
        System.out.println(count);
    }


}
