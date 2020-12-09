package sort.insertion;

import lombok.extern.slf4j.Slf4j;
import sort.Sorter;

@Slf4j
public class InsertionSort implements Sorter {
    private static final InsertionSort instance = new InsertionSort();

    private InsertionSort() {

    }

    public static Sorter getInstance() {
        return instance;
    }

    @Override
    public <T extends Comparable> T[] sort(T[] list) {
        T[] result = (T[]) new Comparable[list.length];
        for (int i = 0; i < list.length; i++) {
            Integer correct_pos = findCorrectPosition(result, list[i]);
            result = insertInPosition(result, correct_pos, list[i]);
        }
        return result;
    }


    private <T extends Comparable> T[] insertInPosition(T[] list, Integer idx, T val) {
        if (idx >= list.length) {
            log.warn("can not insert item %s in position %s in list with %s length", val, idx, list.length);
            return list;
        } else {
            Integer last_rightly_filled = findLastRightlyFilledIdx(list);
            if (last_rightly_filled < list.length - 1) {
                list = shift(list, idx, last_rightly_filled);
                list[idx] = val;
            } else {
                list[list.length - 1] = val;
            }
        }
        return list;
    }

    private <T> T[] shift(T[] list, Integer idx, Integer idx2) {
        for (int i = idx2; i >= idx; i--) {
            list[i + 1] = list[i];
        }
        return list;
    }

    private <T> Integer findLastRightlyFilledIdx(T[] list) {
        for (int i = list.length - 1; i >= 0; i--) {
            if (list[i] == null) {
                continue;
            } else {
                return i;
            }
        }
        //for the first item to be inserted in final result list
        return 0;
    }

    private <T extends Comparable> Integer findCorrectPosition(T[] list, T val) {
        Integer pos = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) {
                pos = i;
                break;
            } else if (list[i].compareTo(val) < 0) {
                continue;
            } else {
                pos = i - 1;
                break;
            }
        }
        return pos;
    }
}
