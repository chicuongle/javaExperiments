package sort;

public interface Sorter {
    <T extends Comparable> T[] sort(T[] list);
}
