package dp;

public class BreakBalloon {

    public static int solution(int[] arr){
        int[] help = new int[arr.length + 2];
        help[0] = 1;
        help[help.length - 1] = 1;
        for (int i = 0; i < arr.length; i++) {
            help[i + 1] = arr[i];
        }
        return process(help, 1, help.length - 2);
    }

    public static int process(int[] help, int i, int j){
        if (i == j){
            return help[i - 1] * help[i] * help[i + 1];
        }
        int max = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            int left = 0, right = 0;
            int mid = help[i - 1] * help[k] * help[j + 1];
            if (k == i){
                right = process(help, k + 1, j);
            }else if (k == j){
                left = process(help, i, k - 1);
            }else{
                left = process(help, i, k - 1);
                right = process(help, k + 1, j);
            }
            max = Math.max(max, mid + left + right);
        }
        return max;
    }

    public static int dp(int[] arr){
        int[][] dp = new int[arr.length + 2][arr.length + 2];
        for (int i = 1; i < dp.length - 1; i++) {
            dp[i][i] = dp[i - 1][i - 1] * dp[i][i] * dp[i + 1][i + 1];
        }
        for (int i = dp.length - 3; i >= 1; i--) {
            for (int j = i + 1; j < dp.length - 1; j++) {
                
            }
        }
        return dp[1][dp.length - 2];
    }

    public static void main(String[] args) {
        int[] arr = {3,2,9,8,4,6};
        System.out.println(solution(arr));
    }
}
