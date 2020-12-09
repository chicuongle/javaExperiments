package sort.buble;

import sort.Sorter;

import static sort.buble.BubleSort.swapItem;

public class OptimizedBubleSort implements Sorter {
    private static Sorter instance = new OptimizedBubleSort();

    private OptimizedBubleSort() {

    }

    public static Sorter getInstance() {
        return instance;
    }
    @Override
    public <T extends Comparable> T[] sort(T[] list) {
        boolean swapped = true;
        int length = list.length;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < length - 1; i++) {
                if (list[i].compareTo(list[i + 1]) > 0) {
                    swapItem(list, i, i + 1);
                    swapped = true;
                }
            }
            length --;
        }
        return list;
    }
}
