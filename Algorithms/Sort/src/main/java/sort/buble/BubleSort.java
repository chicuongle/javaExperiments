package sort.buble;

import sort.Sorter;

public class BubleSort implements Sorter {
    private static Sorter instance = new BubleSort();

    private BubleSort() {

    }

    public static Sorter getInstance() {
        return instance;
    }

    @Override
    public <T extends Comparable> T[] sort(T[] list) {

        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < list.length - 1; i++) {
                if (list[i].compareTo(list[i + 1]) > 0) {
                    swapItem(list, i, i + 1);
                    swapped = true;
                }
            }
        }
        return list;
    }

    static <T> T[] swapItem(T[] list, int idx, int idx2) {
        T val = list[idx];
        list[idx] = list[idx2];
        list[idx2] = val;
        return list;
    }
}
