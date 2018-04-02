package dp;

public class backpack01 {

    /**
     * 递归法
     * @param i 处理到第i件物品
     * @param restW 剩余的重量
     */
    public static int backpack(int[] w, int[] p, int i, int restW){
        if (i == -1){
            return 0;
        }
        if (restW >= w[i]) {
            int add = backpack(w, p, i - 1, restW - w[i]) + p[i];
            int nAdd = backpack(w, p, i - 1, restW);
            return Math.max(add, nAdd);
        }
        return backpack(w, p, i - 1, restW);
    }

    /**
     * 动态规划法，dp[i][j]表示前i件物品不超过j的重量的价值最大值
     */
    public static int dp(int[] w, int[] p, int weight){
        if (w == null || p == null || w.length == 0 || p.length == 0){
            throw new RuntimeException("输入不合法");
        }
        int n = w.length;
        int[][] dp = new int[n][weight + 1];
        for (int i = w[0]; i <= weight; i++) {
            dp[0][i] = p[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= weight; j++) {
                if (j < w[i]){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + p[i]);
                }
            }
        }
        return dp[n - 1][weight];
    }

    /**
     * 只用一维数组，dp[i]表示前i+1个物品放到背包的最大价值
     */
    public static int dpPlus(int[] w, int[] p, int weight){
        if (w == null || p == null || w.length == 0 || p.length == 0){
            throw new RuntimeException("输入不合法");
        }
        int[] dp = new int[weight + 1];
        for (int i = 0; i < w.length; i++) {
            for (int j = weight; j >= 0; j--) {
                if (j >= w[i]){
                    dp[j] = Math.max(dp[j - w[i]] + p[i], dp[j]);
                }
            }
        }
        return dp[weight];
    }

    public static void main(String[] args) {
        int[] w = new int[]{4,7,8,2,5,18,12};
        int[] p = new int[]{2,4,5,1,3,15,10};
        int weight = 25;
        System.out.println(backpack(w, p, w.length - 1, weight));
        System.out.println(dp(w, p, weight));
        System.out.println(dpPlus(w, p, weight));
    }
}
