package sort;

import sort.buble.BubleSort;
import sort.buble.OptimizedBubleSort;
import sort.insertion.InsertionSort;
import sort.selection.SelectionSort;

public class SortFactory {
    private static final SortFactory instance = new SortFactory();

    private SortFactory() {

    }

    public static SortFactory getInstance() {
        return instance;
    }

    public Sorter selectionSort() {
        return SelectionSort.getInstance();
    }
    public Sorter insertionSort() {
        return InsertionSort.getInstance();
    }
    public Sorter bubleSort() {
        return BubleSort.getInstance();
    }
    public Sorter optimizedBubleSort() {
        return OptimizedBubleSort.getInstance();
    }
    public Sorter mergeSort() {
        return MergeSort.getInstance();
    }
}
