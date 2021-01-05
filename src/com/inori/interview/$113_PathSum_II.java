package com.inori.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * $113_PathSum_II [Medium]
 * <p>
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
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
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 *
 * @author inori
 * @date 2020/3/19
 */
public class $113_PathSum_II {

    /**
     * 在深度遍历的过程中添加一个list来记录遍历路径上的元素，并且在满足路径和条件时将该list添加到result结果集中。
     * @param root 根节点
     * @param sum 路径和
     * @return 所有满足路径和条件的节点值集合
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        hashPath(root, new ArrayList<>(), result, sum);
        return result;

    }
    public void hashPath(TreeNode node, List<Integer> list, List<List<Integer>> result, int sum) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        sum -= node.val;
        if (node.left == null && node.right == null) {
            if (sum == 0) {
                result.add(new ArrayList<>(list));
            }
            if (list.size() > 0)
                list.remove(list.size() - 1);
            return;
        }
        hashPath(node.left, list, result, sum);
        hashPath(node.right, list, result, sum);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        System.out.println(new $113_PathSum_II().pathSum(root, 4));
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
