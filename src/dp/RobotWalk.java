package dp;

/**
 * 有n个格子，一个机器人可以往左或往右走，但不能越界，初始位置为m，经过p步后走到k位置的走法一共有多少种？
 */
public class RobotWalk {

    /**
     * 递归版本
     * @param restStep 当前剩余多少步
     * @param cur 当前的位置
     * @return 走法数量
     */
    public static int walk(int n, int k, int restStep, int cur){
        if (restStep == 0){
            return cur == k ? 1 : 0;
        }
        if (cur == n){
            return walk(n, k, restStep - 1, cur - 1);
        }
        if (cur == 1){
            return walk(n, k, restStep - 1, cur + 1);
        }
        return walk(n, k, restStep - 1, cur + 1) + walk(n, k, restStep - 1, cur - 1);
    }

    public static int dp(int n, int k, int p, int m){
        int[][] dp = new int[p + 1][n + 1];
        dp[0][k] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == 1){
                    dp[i][j] = dp[i - 1][j + 1];
                }else if (j == n){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                }
            }
        }
        return dp[p][m];
    }

    public static void main(String[] args) {
        int n = 10, m = 4, p = 15, k = 5;
        System.out.println(walk(n, k, p, m));
        System.out.println(dp(n , k, p, m));
    }
}
