package sort;

import java.util.Arrays;
import java.util.Random;

import static sort.Utils.*;

public class QuickSort {

    public static void quickSort(int[] arr){
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r){
        if(l < r){
            swap(arr, new Random().nextInt(r - l + 1) + l , r);
            int[] p = partition(arr, l, r);
            quickSort(arr, l,p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    private static int[] partition(int[] arr, int l, int r) {
        int less = l - 1, more = r;
        while (l < more){
            if(arr[l] < arr[r]){
                swap(arr, ++less, l++);
            }else if(arr[l] > arr[r]){
                swap(arr, --more, l);
            }else{
                l++;
            }
        }
        swap(arr, more, r);
        return new int[]{ less + 1, more };
    }

    public static void main(String[] args) {
        boolean succeed = duishuqi(500000, 50, 100, QuickSort::quickSort, Arrays::sort);
        System.out.println(succeed ? "全部通过" : "fuck");

    }
}
