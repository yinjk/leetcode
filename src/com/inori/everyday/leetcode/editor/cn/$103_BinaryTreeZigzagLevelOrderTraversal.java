/*
//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 342 👎 0

*/

package com.inori.everyday.leetcode.editor.cn;

import java.util.*;

public class $103_BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new $103_BinaryTreeZigzagLevelOrderTraversal().new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        solution.zigzagLevelOrder(root);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            Queue<TreeNode> parent = new LinkedList<>();
            Queue<TreeNode> child = new LinkedList<>();

            parent.add(root);

            int i = 0;
            while (!parent.isEmpty()) {
                Deque<Integer> row = new LinkedList<>();
                //添加所有的child
                for (;!parent.isEmpty();) {
                    TreeNode a = parent.poll();
                    if (a.left != null) child.add(a.left);
                    if (a.right != null) child.add(a.right);
                    if ((i & 1) == 0) { // 偶数 从左到右
                        row.addFirst(a.val);
                    } else { //奇数 从右到左
                        row.addLast(a.val);
                    }
                }
                Queue<TreeNode> tmp = parent;
                parent = child;
                child = tmp;
                i++;
                res.add(new LinkedList<>(row));
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}