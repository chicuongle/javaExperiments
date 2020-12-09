package sort;


public class QuickSort implements Sorter {
    private static Sorter instance = new QuickSort();

    private QuickSort() {

    }

    public static Sorter getInstance() {
        return instance;
    }

    @Override
    public <T extends Comparable> T[] sort(T[] list) {

        throw new RuntimeException("Not implemented");
    }
}
