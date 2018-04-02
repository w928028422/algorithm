package array;

/**
 * 输出旋转数组的最小数字（注意：1.可以旋转0个数字 2.数字有重复值的情况）
 */
public class MinInRotateArray {

    public static int solution(int[] arr){
        if (arr == null || arr.length == 0){
            throw new RuntimeException("数组不合法");
        }
        int left = 0, right = arr.length - 1, mid = 0;
        while (arr[left] >= arr[right]){
            if (right - left == 1){
                return arr[right];
            }
            mid = (left + right) / 2;
            if (arr[left] == arr[mid] && arr[left] == arr[right]){
                for (int i = left + 1; i < right; i++) {
                    if (arr[i] < arr[i - 1]){
                        return arr[i];
                    }
                }
            }
            if (arr[left] <= arr[mid]){
                left = mid;
            }else if (arr[right] >= arr[mid]){
                right = mid;
            }
        }
        return arr[mid];
    }

    public static void main(String[] args) {
        int[][] tests = new int[][]{
                {3,4,5,1,2},{1,2,3,4,5},{1,1,0,1,1},{1,1,1,1,1}
        };
        for (int[] test : tests) {
            System.out.println(solution(test));
        }
    }
}
