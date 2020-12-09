package sort.selection;

import sort.Sorter;

public class SelectionSort implements Sorter {
    private final static SelectionSort instance = new SelectionSort();

    private SelectionSort() {
    }

    public static SelectionSort getInstance() {
        return instance;
    }

    public <T extends Comparable> T[] sort(T[] list) {
        for (int idx = 0; idx < list.length - 1; idx++) {
            Integer idx_smallest_list_tail = findPosSmallestOfTail(list, idx + 1, list.length - 1);
            if (list[idx_smallest_list_tail].compareTo(list[idx]) < 0) {
                list = swapItem(list, idx, idx_smallest_list_tail);
            }
        }
        return list;
    }

    private <T> T[] swapItem(T[] list, Integer idx1, Integer idx2) {
        T pos1 = list[idx1];
        list[idx1] = list[idx2];
        list[idx2] = pos1;
        return list;
    }

    private <T extends Comparable> Integer findPosSmallestOfTail(T[] list, Integer begin, Integer end) {
        T comparator = list[begin];
        Integer idx_of_smallestValue = begin;
        for (int i = begin; i <= end; i++) {
            if (list[i].compareTo(comparator) < 0) {
                comparator = list[i];
                idx_of_smallestValue = i;
            }
        }
        return idx_of_smallestValue;
    }
}
