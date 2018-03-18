package sort;

import java.util.Arrays;

public class InsertSort {

    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                Utils.swap(arr, j, j + 1);
            }
        }
    }

    public static void main(String[] args) {
        boolean succeed = Utils.duishuqi(500000, 50, 100, InsertSort::insertSort, Arrays::sort);
        System.out.println(succeed ? "全部通过" : "fuck");
    }
}
