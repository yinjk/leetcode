/*
//如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数
//值排序之后中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例 1： 
//
// 输入：
//["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
//[[],[1],[2],[],[3],[]]
//输出：[null,null,null,1.50000,null,2.00000]
// 
//
// 示例 2： 
//
// 输入：
//["MedianFinder","addNum","findMedian","addNum","findMedian"]
//[[],[2],[],[3],[]]
//输出：[null,null,2.00000,null,2.50000] 
//
// 
//
// 限制： 
//
// 
// 最多会对 addNum、findMedian 进行 50000 次调用。 
// 
//
// 注意：本题与主站 295 题相同：https://leetcode-cn.com/problems/find-median-from-data-strea
//m/ 
// Related Topics 堆 设计 
// 👍 83 👎 0

*/

package com.inori.swordoffer;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class $v41_ShuJuLiuZhongDeZhongWeiShuLcof {
    public static void main(String[] args) {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        p.add(3);
        p.add(1);
        p.add(2);
        p.add(5);
        Integer poll = p.poll();
        System.out.println(poll);


    }

    class MedianFinder {
        PriorityQueue<Integer> low;
        PriorityQueue<Integer> high;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            this.low = new PriorityQueue<>();
            this.high = new PriorityQueue<>(11, (i1, i2) -> -Integer.compare(i1, i2));

        }

        public void addNum(int num) {
            if (low.size() > high.size()) {
                low.add(num);
                high.add(low.poll());
            } else {
                high.add(num);
                low.add(high.poll());

            }
        }

        public double findMedian() {
            return low.size() > high.size() ? low.peek() : (low.peek() + high.peek()) / 2.0;
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */


}