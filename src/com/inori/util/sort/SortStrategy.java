package com.inori.util.sort;


/**
 * SortStrategy
 *
 * @author inori
 * @date 2020/12/3
 */
public enum SortStrategy {
    MergeSort(new MergeSort()),
    QuickSort(new QuickSort()),
    BubbleSort(new BubbleSort()),
    ;
    private Sorter sorter;

    SortStrategy(Sorter sorter) {
        this.sorter = sorter;
    }

    public Sorter getSorter() {
        return sorter;
    }
}
