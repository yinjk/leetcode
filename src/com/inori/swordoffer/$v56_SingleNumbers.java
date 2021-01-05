package com.inori.swordoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * $v56_SingleNumbers
 * <p>
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *  
 * <p>
 * 限制：
 * <p>
 * 2 <= nums <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author inori
 * @date 2020/4/28
 */
public class $v56_SingleNumbers {

    public int[] singleNumbers(int[] nums) {
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
            return new int[]{r1, r2};
    }

    public static void main(String[] args) {
        int[] req = new int[]{1, 3, 4, 6, 1, 5, 5, 6, 3, 7, 7, 9};
        System.out.println(Arrays.toString(new $v56_SingleNumbers().singleNumbers(req)));
    }


}
