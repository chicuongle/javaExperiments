package sort;

public class BucketSort implements Sorter {
    private static Sorter instance = new BucketSort();

    private BucketSort() {

    }

    public static Sorter getInstance() {
        return instance;
    }

    @Override
    public <T extends Comparable> T[] sort(T[] list) {

        throw new RuntimeException("Not implemented");
    }
}