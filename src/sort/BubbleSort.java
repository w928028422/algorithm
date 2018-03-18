package sort;

import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(int[] arr){
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[j + 1]){
                    Utils.swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        boolean succeed = Utils.duishuqi(500000, 50, 100, BubbleSort::bubbleSort, Arrays::sort);
        System.out.println(succeed ? "全部通过" : "fuck");
    }


}
