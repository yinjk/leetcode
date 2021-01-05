/*
//请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指
//向链表中的任意节点或者 null。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
// 
//
// 示例 2： 
//
// 
//
// 输入：head = [[1,1],[2,1]]
//输出：[[1,1],[2,1]]
// 
//
// 示例 3： 
//
// 
//
// 输入：head = [[3,null],[3,0],[3,null]]
//输出：[[3,null],[3,0],[3,null]]
// 
//
// 示例 4： 
//
// 输入：head = []
//输出：[]
//解释：给定的链表为空（空指针），因此返回 null。
// 
//
// 
//
// 提示： 
//
// 
// -10000 <= Node.val <= 10000 
// Node.random 为空（null）或指向链表中的节点。 
// 节点数目不超过 1000 。 
// 
//
// 
//
// 注意：本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-point
//er/ 
//
// 
// Related Topics 链表 
// 👍 120 👎 0

*/

package com.inori.swordoffer;

import java.util.HashMap;
import java.util.Map;

public class $v35_FuZaLianBiaoDeFuZhiLcof {
    public static void main(String[] args) {
        Solution solution = new $v35_FuZaLianBiaoDeFuZhiLcof().new Solution();
    }

    /*
    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    */
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        /**
         * 第一遍遍历，将新节点和旧结点建立hash关联关系，第二遍遍历，从hash表中取出旧结点对应的新节点赋值给next和random即可。
         * 时间复杂度 O(N) 空间复杂度 O(N)
         *
         * @param head 头结点
         * @return 拷贝的链表
         */
        public Node copyRandomList(Node head) {
            Node dump = new Node(0), pre = dump;
            Node node = head;
            Map<Node, Node> map = new HashMap<>();
            while (node != null) {
                map.put(node, new Node(node.val));
                node = node.next;
            }
            node = head;
            while (node != null) {
                pre.next = map.get(node);
                pre.next.random = map.get(node.random);
                pre = pre.next;
                node = node.next;
            }
            return dump.next;
        }
    }


}