package sort;

import java.util.Arrays;

public class SelectionSort {

    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            Utils.swap(arr, i, minIndex);
        }
    }

    public static void main(String[] args) {
        boolean succeed = Utils.duishuqi(500000, 50, 100, SelectionSort::selectionSort, Arrays::sort);
        System.out.println(succeed ? "全部通过" : "fuck");
    }
}
