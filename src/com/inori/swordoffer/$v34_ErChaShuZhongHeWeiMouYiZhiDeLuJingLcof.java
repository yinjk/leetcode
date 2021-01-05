/*
//输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。 
//
// 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/ 
// Related Topics 树 深度优先搜索 
// 👍 110 👎 0

*/

package com.inori.swordoffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class $v34_ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof {
    public static void main(String[] args) {
        Solution solution = new $v34_ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof().new Solution();
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
        private List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            pathSum(root, new ArrayList<>(), sum);
            return res;
        }

        public void pathSum(TreeNode node, List<Integer> path, int tar) {
            if (node ==null) return;
            path.add(node.val);
            tar -= node.val;
            //叶子节点，并且路径和等于目标值
            if (tar == 0 && node.left == null && node.right == null) {
                res.add(new ArrayList<>(path));
                //这里不要急着return，为了执行后面的path.remove语句
            }
            pathSum(node.left, path, tar);
            pathSum(node.right, path, tar);
            path.remove(path.size() - 1);
        }
    }


}