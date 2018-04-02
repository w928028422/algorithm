package array;

import static sort.Utils.swap;

/**
 * 找出数组中任意一个重复的数字
 */
public class DuplicateNumber {

    public static Integer solution(int[] arr){
        if (arr == null){
            return null;
        }
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i){
                if (arr[i] == arr[arr[i]]){
                    return arr[i];
                }
                swap(arr, i, arr[i]);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = new int[15];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println(solution(arr));
    }
}
