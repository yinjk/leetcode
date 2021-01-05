package com.inori.swordoffer;

import java.util.Stack;

/**
 * $v09_YongLiangGeZhanShiXianDuiLieLcof
 *
 * @author inori
 * @date 2020/11/24
 */
public class $v09_YongLiangGeZhanShiXianDuiLieLcof {
    public static void main(String[] args) {
         CQueue obj = new CQueue();
         obj.appendTail(1);
         int param_2 = obj.deleteHead();
    }

    static class CQueue {
        Stack<Integer> stackIn = new Stack<>();
        Stack<Integer> stackOut = new Stack<>();

        public CQueue() {

        }

        public void appendTail(int value) {
            stackIn.push(value);
        }

        public int deleteHead() {
            if (stackOut.isEmpty()) {
                while (!stackIn.isEmpty()) {
                    stackOut.push(stackIn.pop());
                }
            }
            if (stackOut.isEmpty()) return -1;
            return stackOut.pop();
        }
    }
}
