package com.inori.util.search;

public enum SearchStrategy {
    //二分查找
    BinarySearch(new BinarySearch()),
    ;

    private final Searchable strategy;

    SearchStrategy(Searchable strategy) {
        this.strategy = strategy;
    }

    public Searchable getStrategy() {
        return this.strategy;
    }
}
