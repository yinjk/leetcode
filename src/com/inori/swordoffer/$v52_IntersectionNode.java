package com.inori.swordoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * $52_IntersectionNode [Easy]
 * <p>
 * 输入两个链表，找出它们的第一个公共节点。
 * <p>
 * 如下面的两个链表：
 * <p>
 * <p>
 * <p>
 * 在节点 c1 开始相交。
 * <p>
 * 示例 1：
 * <p>
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 * <p>
 * <p>
 * 注意：
 * <p>
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * 本题与主站 160 题相同：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 *
 * @author inori
 * @date 2020/3/20
 */

public class $v52_IntersectionNode {

    /**
     * 暴力求解，不解释 时间复杂度O(n^2)
     *
     * @param headA 链表1
     * @param headB 链表2
     * @return 相交点
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        while (nodeA != null) {
            ListNode nodeB = headB;
            while (nodeB != null) {
                if (nodeA == nodeB) {
                    return nodeA;
                }
                nodeB = nodeB.next;
            }
            nodeA = nodeA.next;
        }
        return null;
    }

    /**
     * 从后向前遍历法：先遍历一遍两个链表，将两个链表的节点放到两个list中，然后从后向前遍历这个list，因为两个相交的链表的最后一个节点一定是相同的，
     * 所有当出现两个链表的节点不同时，那上一个节点就是相交点。 时间复杂度 O(M+2N) 空间复杂度o(M+N)
     *
     * @param headA 链表1
     * @param headB 链表2
     * @return 相交点
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        List<ListNode> listA = new ArrayList<>();
        List<ListNode> listB = new ArrayList<>();
        while (nodeA != null) {
            listA.add(nodeA);
            nodeA = nodeA.next;
        }
        while (nodeB != null) {
            listB.add(nodeB);
            nodeB = nodeB.next;
        }
        int a = listA.size() - 1;
        int b = listB.size() - 1;
        //最后一个元素都不相交，表明两个链表不相交
        if (listA.get(a) != listB.get(b)) {
            return null;
        }
        for (int i = 0; i < a; i++) {
            if (b - 1 - i < 0) {
                return listA.get(a - i);
            }
            if (listA.get(a - 1 - i) != listB.get(b - 1 - i)) {
                return listA.get(a - i);
            }
        }

        return b >= a ? headA : null;
    }

    /**
     * 题解：https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/solution/zhao-chu-liang-ge-lian-biao-de-xiang-jiao-bu-fen-j/
     * 时间复杂度:O(M+2N)  空间复杂度:O(1)
     *
     * @param headA 链表1
     * @param headB 链表2
     * @return 相交点
     */
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        int n = 0;
        ListNode endA = null, endB = null;
        while (nodeA != null) {
            endA = nodeA.next == null ? nodeA : null;
            nodeA = nodeA.next;
            n++;
        }
        while (nodeB != null) {
            endB = nodeB.next == null ? nodeB : null;
            nodeB = nodeB.next;
            n--;
        }
        if (endA != endB) {
            return null;
        }
        nodeA = n > 0 ? headA : headB;
        nodeB = nodeA == headA ? headB : headA;
        n = Math.abs(n);
        while (n > 0) {
            nodeA = nodeA.next;
            n--;
        }
        while (nodeA != nodeB) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return nodeA;
    }


    /**
     * 浪漫的相遇：我们使用两个指针 node1，node2 分别指向两个链表 headA，headB 的头结点，然后同时分别逐结点遍历，
     * 当 node1 到达链表 headA 的末尾时，重新定位到链表 headB 的头结点；当 node2 到达链表 headB 的末尾时，重新定位到链表 headA 的头结点。
     * 这样，当它们相遇时，所指向的结点就是第一个公共结点。 时间复杂度: O(M+N)   空间复杂度: O(1)
     * 题解：https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/solution/shuang-zhi-zhen-fa-lang-man-xiang-yu-by-ml-zimingm/
     * <p>
     * 我超级喜欢这个解法，当然我也没有想到有如此巧妙、优雅、智慧的解法，我也超级喜欢这个解法的命名，真是个浪漫的相遇啊。
     *
     * @param headA 链表1
     * @param headB 链表2
     * @return 相交点
     */
    public ListNode getIntersectionNode4(ListNode headA, ListNode headB) {
        ListNode nodeA = headA, nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }
        return nodeA;
    }


    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = headA.next.next;
        System.out.println(new $v52_IntersectionNode().getIntersectionNode1(headA, headB).val);
        System.out.println(new $v52_IntersectionNode().getIntersectionNode2(headA, headB).val);
        System.out.println(new $v52_IntersectionNode().getIntersectionNode3(headA, headB).val);
        System.out.println(new $v52_IntersectionNode().getIntersectionNode4(headA, headB).val);
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
