package array;

import java.util.Arrays;

import static sort.Utils.swap;

/**
 * 调整数组顺序使奇数在偶数前面
 */
public class ReorderOddEven {

    public static void solution(int[] arr){
        if (arr == null){
            return;
        }
        int begin = 0, end = arr.length - 1;
        while (begin < end){
            while (begin < end && (arr[begin] & 0x1) != 0){
                begin++;
            }
            while (begin < end && (arr[end] & 0x1) == 0){
                end--;
            }
            if (begin < end){
                swap(arr, begin, end);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,6,7,8,9,4,3,2,1,2,6,8};
        solution(arr);
        System.out.println(Arrays.toString(arr));
    }
}
