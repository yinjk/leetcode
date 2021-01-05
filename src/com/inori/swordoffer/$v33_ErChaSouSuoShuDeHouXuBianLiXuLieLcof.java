/*
//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// 👍 150 👎 0

*/

package com.inori.swordoffer;

public class $v33_ErChaSouSuoShuDeHouXuBianLiXuLieLcof {
    public static void main(String[] args) {
        Solution solution = new $v33_ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
        System.out.println(solution.verifyPostorder(new int[]{5, 2, -17, -11, 25, 76, 62, 98, 92, 61}));
    }

    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            return recur(postorder, 0, postorder.length - 1);
        }

        public boolean recur(int[] postorder, int left, int right) {
            if (left >= right) return true;
            int i = left, m = i;// m是右子树的起点
            while (postorder[i++] < postorder[right]) {
                m = i;
            }
            while (i < right) {
                if (postorder[i++] < postorder[right]) {
                    return false;
                }
            }
            return recur(postorder, left, m - 1) && recur(postorder, m, right - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}