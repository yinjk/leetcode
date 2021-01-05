/*
//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回： 
//
// [3,9,20,15,7]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 
// 👍 52 👎 0

*/

package com.inori.swordoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class $v32_I_CongShangDaoXiaDaYinErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new $v32_I_CongShangDaoXiaDaYinErChaShuLcof().new Solution();
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
        public int[] levelOrder(TreeNode root) {
            if (root == null) return new int[0];
            Queue<TreeNode> queue = new LinkedList<>();
            List<Integer> result = new ArrayList<>();
            queue.add(root);
            while (queue.size() > 0) {
                TreeNode value = queue.poll();
                result.add(value.val);
                if (value.left != null) queue.offer(value.left);
                if (value.right != null) queue.offer(value.right);
            }
            int[] ints = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                ints[i] = result.get(i);
            }
            return ints;
        }
    }


}