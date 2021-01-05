package com.inori.interview;

import com.sun.source.tree.Tree;

/**
 * $112_PathSum [Easy]
 * <p>
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * @author inori
 * @date 2020/3/18
 */
public class $112_PathSum {

    /**
     * 使用深度优先遍历二叉树，多加了一个函数来递归显得不太优雅
     *
     * @param root 根节点
     * @param sum  期望和
     * @return 是否存在期望和
     */
    public boolean hasPathSum1(TreeNode root, int sum) {
        return check(root, 0, sum);
    }

    /**
     * 使用深度优先遍历二叉树，更加优雅的实现方式
     *
     * @param root 根节点
     * @param sum  期望和
     * @return 是否存在期望和
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if (root.left == null && root.right == null) {
            return sum == 0;
        }
        //递归搜索左子树和右子树
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    public boolean check(TreeNode node, int sum, int expect) {
        if (node == null) {
            return false;
        }
        boolean left = false, right = false;
        if (node.left != null) {
            left = check(node.left, sum + node.val, expect);
        }
        if (node.right != null) {
            right = check(node.right, sum + node.val, expect);
        }
        if (node.left == null && node.right == null) {
            return node.val + sum == expect;
        }
        return left || right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);
        System.out.println(new $112_PathSum().hasPathSum1(root, 4));
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
