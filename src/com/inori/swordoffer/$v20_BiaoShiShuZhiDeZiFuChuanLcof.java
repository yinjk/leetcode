/*
//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"012
//3"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。 
//
// 
// Related Topics 数学 
// 👍 127 👎 0

*/

package com.inori.swordoffer;

public class $v20_BiaoShiShuZhiDeZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new $v20_BiaoShiShuZhiDeZiFuChuanLcof().new Solution();
        System.out.println(solution.isNumber("+5.6e+12.6"));
    }

    class Solution {
        public boolean isNumber(String s) {
            if (s.length() == 0) return false;
            char[] chars = s.toCharArray();
            boolean dot = false;
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (c == '+' || c == '-') {
                    if (i == 0) continue;
                    return false;
                } else if (c == 'e' || c == 'E') {
                    return isNumber(s.substring(i + 1));
                } else if (c == '.') {
                    if (dot || i == 0) {
                        return false;
                    } else {
                        dot = true;
                    }

                } else if (c < '0' || c > '9') {
                    return false;
                }
            }
            return true;
        }
    }


}