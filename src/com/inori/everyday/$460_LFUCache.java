package com.inori.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * $460_LFUCache
 *
 * @author inori
 * @date 2020/4/5
 */
public class $460_LFUCache {

    private Map<Integer, Integer> data;
    private int capacity;
    public $460_LFUCache(int capacity) {
        this.data = new HashMap<>();
        this.capacity = capacity;

    }

    public int get(int key) {
        return data.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        if (data.size() < capacity) {
            this.data.put(key, value);
            return;
        }
    }
}
