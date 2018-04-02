package dp;

/**
 * 找零钱问题
 */
public class KeepChange {

    public static int process(int[] arr, int index, int aim){
        if (index == arr.length){
            return aim == 0 ? 1 : 0;
        }
        int res = 0;
        for (int i = 0; arr[index] * i <= aim; i++) {
            res += process(arr, index + 1, aim - arr[index] * i);
        }
        return res;
    }

    /**
     * dp[i][j]表示用arr[i]的钱数组成j的钱数有多少方法
     */
    public static int dp(int[] arr, int aim){
        int[][] dp = new int[arr.length][aim + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i % arr[0] == 0 ? 1 : 0;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j >= arr[i]) {
                    dp[i][j] = dp[i][j - arr[i]] + dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[dp.length - 1][aim];
    }

    public static void main(String[] args) {
        int[] arr = {2,5,10,25};
        System.out.println(process(arr, 0, 1000));
        System.out.println(dp(arr, 1000));
    }
}
