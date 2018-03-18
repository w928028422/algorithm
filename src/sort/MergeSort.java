package sort;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        sortProcess(arr, 0, arr.length - 1);
    }

    private static void sortProcess(int[] arr, int l, int r) {
        if(l == r){
            return;
        }
        int mid = (l + r) / 2;
        sortProcess(arr, l, mid);
        sortProcess(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l, p2 = mid + 1, i = 0;
        while (p1 <= mid && p2 <= r){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid){
            help[i++] = arr[p1++];
        }
        while (p2 <= r){
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[l + j] = help[j];
        }
    }

    public static void main(String[] args) {
        boolean succeed = Utils.duishuqi(500000, 50, 100, MergeSort::mergeSort, Arrays::sort);
        System.out.println(succeed ? "全部通过" : "fuck");
    }
}
