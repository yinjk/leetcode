package com.inori.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * $409_LongestPalindrome [Easy]
 * <p>
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * <p>
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * <p>
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "abccccdd"
 * <p>
 * 输出:
 * 7
 * <p>
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 *
 * @author inori
 * @date 2020/3/19
 */
public class $409_LongestPalindrome {

    /**
     *
     *
     * @param s 输入字符串
     * @return 最长回文串的长度
     */
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int palindromeLen = 0;
        for (Integer value : map.values()) {
            palindromeLen = value % 2 == 0 ? palindromeLen + value : palindromeLen % 2 == 0 ? palindromeLen + value : palindromeLen + value - 1;
        }
        return palindromeLen;
    }

    public static void main(String[] args) {
        System.out.println(new $409_LongestPalindrome().longestPalindrome("abccccdd"));
    }
}
