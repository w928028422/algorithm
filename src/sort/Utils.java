package sort;

import java.util.Random;

public class Utils {

    public static int[] randomGenerator(int size, int value){
        Random random = new Random();
        int[] arr = new int[random.nextInt(size)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(value);
        }
        return arr;
    }

    private static int[] arrayCopy(int[] arr){
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static boolean duishuqi(int time, int size, int value, TestMethod tm, RightMethod rm){
        for (int i = 0; i < time; i++) {
            int[] arr1 = randomGenerator(size, value);
            int[] arr2 = arrayCopy(arr1);
            int[] arr3 = arrayCopy(arr1);
            tm.testMethod(arr1);
            rm.rightMethod(arr2);
            if(!isEqual(arr1, arr2)){
                printArray(arr3);
                return false;
            }
        }
        return true;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static boolean isEqual(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }

    public static void swap(int[] arr, int j, int i) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static long timeCount(TestMethod method, int count, int size, int value){
        long begin = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            int[] arr = randomGenerator(size, value);
            method.testMethod(arr);
        }
        long end = System.currentTimeMillis();
        return end - begin;
    }
}
