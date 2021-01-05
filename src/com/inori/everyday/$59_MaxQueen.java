package com.inori.everyday;

import java.util.Stack;

/**
 * $59_MaxQueen
 * <p>
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的时间复杂度都是O(1)。
 * <p>
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * 示例 2：
 * <p>
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= push_back,pop_front,max_value的总操作数 <= 10000
 * 1 <= value <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author inori
 * @date 2020/3/7
 */
public class $59_MaxQueen {

    private int maxValue;
    private int maxCount;
    private int headIndex = 0;
    private int endIndex = 0;
    private int[] data = new int[10000];
    private Stack<Integer> max = new Stack<>();

    public $59_MaxQueen() {

    }

    public int max_value() {
        return -1;

    }

    public void push_back(int value) {
        data[endIndex++] = value;
        maxValue = Math.max(maxValue, value);
    }

    public int pop_front() {
        return -1;
    }
}
