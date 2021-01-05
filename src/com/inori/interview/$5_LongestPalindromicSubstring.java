package com.inori.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * $5_LongestPalindromicSubstring [Medium]
 *
 * @author inori
 * @date 2020/3/6
 */
public class $5_LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        List<Character> p = new ArrayList<>();
        int n = s.length();
        int left = 0;
        int i = 0;
        int max = 0;
        p.add(s.charAt(i));
        return "";
    }



    public static void main(String[] args) {
        String s = "abcdjjfdfabcdcba";
        System.out.println(new $5_LongestPalindromicSubstring().longestPalindrome(s));
    }
}
