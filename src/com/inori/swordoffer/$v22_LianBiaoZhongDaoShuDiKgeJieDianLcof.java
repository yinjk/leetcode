/*
//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，
//它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。 
//
// 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5. 
// Related Topics 链表 双指针 
// 👍 110 👎 0

*/

package com.inori.swordoffer;

public class $v22_LianBiaoZhongDaoShuDiKgeJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new $v22_LianBiaoZhongDaoShuDiKgeJieDianLcof().new Solution();
        solution.getKthFromEnd(null, 2);
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {

        //双指针解法,只用循环一轮
        public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode pre = head, last = head;
            int i = 0;
            while (last.next != null) {
                if (++i >= k) {
                    pre = pre.next;
                }
                last = last.next;
            }
            return pre;
        }

        //常规解法，多循环一轮，如果使用双指针解法只用循环一轮
        public ListNode getKthFromEnd1(ListNode head, int k) {
            int count = 0;
            ListNode node = head;
            while (node != null) {
                count++;
                node = node.next;
            }
            node = head;
            for (int i = 0; i < count - k; i++) {
                node = node.next;
            }
            return node;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


}