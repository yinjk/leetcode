package com.inori.everyday;

import java.util.Stack;

/**
 * $445_AddTwoNum
 *
 * @author inori
 * @date 2020/4/14
 */
public class $445_AddTwoNum {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode listNode = new $445_AddTwoNum().addTwoNumbers(l1, l2);
        System.out.println(listNode);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        Stack<Integer> result = new Stack<>();
        int c = 0;
        while (!(stack1.empty() && stack2.empty() && c == 0)) {
            Integer i1 = stack1.empty() ? 0 : stack1.pop();
            Integer i2 = stack2.empty() ? 0 : stack2.pop();
            int r = i1 + i2 + c;
            result.push(r % 10);
            c = r / 10;
        }
        if (result.empty()) return null;
        ListNode head = new ListNode(result.pop());
        ListNode current = head;
        while (!result.isEmpty()) {
            current.next = new ListNode(result.pop());
            current = current.next;
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
