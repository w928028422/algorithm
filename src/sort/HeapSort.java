package sort;

import java.util.Arrays;

import static sort.Utils.*;

public class HeapSort {

    public static void heapSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while(heapSize > 0){
            heapify(arr,0,  heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    private static void heapify(int[] arr, int i, int heapSize) {
        int left = 2 * i + 1;
        while (left < heapSize){
            int largest = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1 : left;
            largest = arr[i] > arr[largest] ? i : largest;
            if(largest == i){
                break;
            }
            swap(arr, largest, i);
            i = largest;
            left = 2 * i + 1;
        }
    }

    private static void heapInsert(int[] arr, int i) {
        while(arr[i] > arr[(i - 1) / 2]){
            swap(arr, i, (i - 1) /2 );
            i = (i - 1)/2;
        }
    }

    public static void main(String[] args) {
        boolean succeed = Utils.duishuqi(500000, 50, 100, HeapSort::heapSort, Arrays::sort);
        System.out.println(succeed ? "全部通过" : "fuck");
    }
}
