package array;


public class BinarySearch {

    public static int binarySearch(int[] arr, int target){
        int left = 0, right = arr.length;
        while (left < right){
            int mid = (left - right) / 2 + right;
            if (target < arr[mid]){
                right = mid;
            }else if (target > arr[mid]){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,10,15,20};
        System.out.println(binarySearch(arr, 12));
    }
}
