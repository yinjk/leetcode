/*
//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构) 
//
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。 
//
// 例如: 
//给定的树 A: 
//
// 3 
// / \ 
// 4 5 
// / \ 
// 1 2 
//给定的树 B： 
//
// 4 
// / 
// 1 
//返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。 
//
// 示例 1： 
//
// 输入：A = [1,2,3], B = [3,1]
//输出：false
// 
//
// 示例 2： 
//
// 输入：A = [3,4,5,1,2], B = [4,1]
//输出：true 
//
// 限制： 
//
// 0 <= 节点个数 <= 10000 
// Related Topics 树 
// 👍 154 👎 0

*/

package com.inori.swordoffer;

public class $v26_ShuDeZiJieGouLcof {
    public static void main(String[] args) {
        Solution solution = new $v26_ShuDeZiJieGouLcof().new Solution();
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            // recur函数开始匹配A和B，若匹配失败，则查看A的左子树和右子树是否能匹配B
            return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
        }

        //开始匹配，
        public boolean recur(TreeNode A, TreeNode B) {
            if (B == null) return true; //若B为空，则表示B已经匹配完了，表示B是A的左子树
            if (A == null || A.val != B.val) return false; //若A为空表示B还没匹配完，但A已经为空了，说明A不能匹配B
            return recur(A.left, B.left) && recur(A.right, B.right); //分别匹配A的左子树、B的左子树 和 A的右子树、B的右子树
        }

    }


}