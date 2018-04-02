package dp;

/**
 * 判断一个数组arr中的数字累加是否可以等于aim
 */
public class SumEqualsNum {
    /**
     *递归版本
     * @param i 当前来到数组的位置
     * @param sum 当前累加和
     * @param aim 目标累加和
     */
    public static boolean isAim(int[] arr, int i, int sum, int aim){
        if (i == arr.length){
            return sum == aim;
        }
        return isAim(arr, i + 1, sum, aim) || isAim(arr, i + 1, sum + arr[i], aim);
    }

    public static boolean dp(int[] arr, int aim){
        int sum = 0, n = arr.length;
        for (int a : arr){
            sum += a;
        }
        boolean[][] dp = new boolean[n + 1][sum + 1];
        dp[n][aim] = true;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= sum - arr[i]; j++) {
                dp[i][j] = dp[i + 1][j] || dp[i + 1][j + arr[i]];
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10,2,7,25,3};
        System.out.println(isAim(arr, 0, 0, 37));
        System.out.println(dp(arr, 37));
    }
}
