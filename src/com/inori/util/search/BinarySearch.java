package com.inori.util.search;

/**
 * BinarySearch
 *
 * @author inori
 * @date 2020/12/3
 */
public class BinarySearch implements Searchable {
    /**
     * 二分查找法，时间复杂度O(log N)，空间复杂度O(1)
     *
     * @param source 升序排序的int数组
     * @param target 要查找的目标
     * @return 目标对应的下标
     */
    @Override
    public int find(int[] source, int target) {
        if (source == null) return -1;
        int low = 0, high = source.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2; //避免大数溢出
            if (source[mid] < target) {
                low = mid + 1;
            } else if (source[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
