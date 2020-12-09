package sort;

public class MergeSort implements Sorter {
    private static Sorter instance = new MergeSort();

    private MergeSort() {

    }

    public static Sorter getInstance() {
        return instance;
    }

    @Override
    public <T extends Comparable> T[] sort(T[] list) {
        if (list.length <= 1) {
            return list;
        }
        int leftLength = list.length / 2;
        T[] left = (T[]) new Comparable[leftLength];
        T[] right = (T[]) new Comparable[list.length - leftLength];
        for (int i = 0; i < list.length; i++) {
            if (i < leftLength) {
                left[i] = list[i];
            } else {
                right[i - leftLength] = list[i];
            }
        }
        left = sort(left);
        right = sort(right);
        return merge(left, right);
    }

    private <T extends Comparable> T[] merge(T[] left, T[] right) {
        T[] result = (T[]) new Comparable[left.length + right.length];
        int leftIdx = 0;
        int rightIdx = 0;

        int idx = 0;
        do {
            if (left[leftIdx].compareTo(right[rightIdx]) < 0) {
                result[idx] = left[leftIdx];
                leftIdx++;
            } else {
                result[idx] = right[rightIdx];
                rightIdx++;
            }
            idx++;
        } while (leftIdx < left.length && rightIdx < right.length);

        while (leftIdx < left.length) {
            result[idx] = left[leftIdx];
            leftIdx++;
            idx++;
        }

        while (rightIdx < right.length) {
            result[idx] = right[rightIdx];
            rightIdx++;
            idx++;
        }
        return result;
    }
}
