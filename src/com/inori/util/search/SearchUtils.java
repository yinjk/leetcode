package com.inori.util.search;

/**
 * SearchUtils
 *
 * @author inori
 * @date 2020/12/3
 */
public class SearchUtils {

    public static int find(int[] a, int target) {
        return find(a, target, SearchStrategy.BinarySearch);
    }

    public static int find(int[] a, int target, SearchStrategy searchStrategy) {
        return searchStrategy.getStrategy().find(a, target);
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 4, 5, 6, 8, 9, 10};
        int i = find(a, 6);
        System.out.println(i);
    }
}
