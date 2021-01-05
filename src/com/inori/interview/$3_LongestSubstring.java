package com.inori.interview;


import java.util.HashMap;
import java.util.Map;

/**
 * $3_LongestSubstring [Medium]
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author inori
 * @date 2020/3/5
 */
public class $3_LongestSubstring {

    /**
     * 时间复杂度过高
     *
     * @param s 查询字符串
     * @return the longest no repeat substring
     */
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length() && (s.length() - i > max); ) {
            int len = 1;
            for (int j = i + 1; j < s.length(); j++) {
                int index = check(s, i, j);
                if (index != -1) {//重复了
                    i = index + 1;
                    break; //跳出循环
                }
                len = j - i + 1;
            }
            max = Math.max(max, len);
        }
        return max;
    }

    public int check(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                return i;
            }
            i++;
        }
        return -1;
    }


    /**
     * 使用滑动窗口的方式求解，时间复杂度O(n),空间复杂度O(n)
     *  [important 1]: Math.max 可以避免取到之前存在的重复项
     *
     * @param s 查询字符串
     * @return the longest no repeat substring
     */
    public int lengthOfLongestSubstring2(String s) {
        int max = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1); // [important 1]
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "iloveyou";
        System.out.println(new $3_LongestSubstring().lengthOfLongestSubstring2(s));
    }
}
