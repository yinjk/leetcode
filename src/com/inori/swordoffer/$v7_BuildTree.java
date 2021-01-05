package com.inori.swordoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * $v7_BuildTree [Easy]
 * <p>
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author inori
 * @date 2020/3/26
 */
public class $v7_BuildTree {

    public static void main(String[] args) {
        new $v7_BuildTree().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }

    /**
     * 通过递归的方式重建
     *
     * @param preorder 前序数组
     * @param inorder  中序数组
     * @return 重建的二叉树
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> index = new HashMap<>();
        //索引一遍中序数组，便于通过root找到左右子树的起始位置
        for (int i = 0; i < inorder.length; i++) {
            index.put(inorder[i], i);
        }
        return buildTree(preorder, index, 0, 0, preorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, Map<Integer, Integer> index, int root, int left, int right) {
        if (left > right) return null;
        TreeNode node = new TreeNode(preorder[root]);// 建立根节点
        Integer i = index.get(node.val); // 划分根节点、左子树、右子树
        //注意：root的位置是在前序（preorder）中找的, left和right的位置是在中序（inorder）中找的
        node.left = buildTree(preorder, index, root + 1, left, i - 1); // 开启左子树递归
        node.right = buildTree(preorder, index, root + i - left + 1, i + 1, right);// 开启右子树递归
        return node;// 回溯返回根节点
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
