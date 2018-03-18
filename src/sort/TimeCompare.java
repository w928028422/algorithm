package sort;

import java.util.Arrays;

import static sort.Utils.timeCount;

public class TimeCompare {
    public static void main(String[] args) {
        System.out.println(timeCount(Arrays::sort, 1000, 1000, 100));
        System.out.println(timeCount(QuickSort::quickSort, 1000, 1000, 100));
        System.out.println(timeCount(MergeSort::mergeSort, 1000, 1000, 100));
        System.out.println(timeCount(InsertSort::insertSort, 1000, 1000, 100));
        System.out.println(timeCount(BubbleSort::bubbleSort, 1000, 1000, 100));
        System.out.println(timeCount(SelectionSort::selectionSort, 1000, 1000, 100));
    }
}
