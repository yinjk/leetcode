/*
//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例: 
//
// s = "abaccdeff"
//返回 "b"
//
//s = "" 
//返回 " "
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 哈希表 
// 👍 63 👎 0

*/

package com.inori.swordoffer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class $v50_DiYiGeZhiChuXianYiCiDeZiFuLcof {
    public static void main(String[] args) {
        Solution solution = new $v50_DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();
        int[] nums = new int[]{2, 5, 4, 4, 1, 3, 4, 4, 1, 4, 4, 1, 2, 1, 2, 2, 3, 2, 4, 2};
        int k = 3;
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int r = map.getOrDefault(k - nums[i], 0);
            if (r > 0) {
                res++;
                map.put(k - nums[i], r - 1);
            } else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        System.out.println(res);
    }

    class Solution {
        public char firstUniqChar(String s) {
            Map<Character, Boolean> map = new LinkedHashMap<>();
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), !map.containsKey(s.charAt(i)));
            }
            for (Character character : map.keySet()) {
                if (map.get(character)) {
                    return character;
                }
            }
            return ' ';
        }
    }
}