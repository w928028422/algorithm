package dp;

import java.util.Random;

public class LongestCommonSubSequence {

    public static int solution(char[] s1, char[] s2){
        int m = s1.length, n = s2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1[i - 1] == s2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static int force(char[] s1, char[] s2, int i, int j){
        if (i >= s1.length || j >= s2.length){
            return 0;
        }
        if (s1[i] == s2[j]){
            return force(s1, s2, i + 1, j + 1) + 1;
        }
        return Math.max(force(s1, s2, i + 1, j), force(s1, s2, i, j + 1));
    }

    public static void main(String[] args) {
        char[] s1 = new char[2000], s2 = new char[1000];
        Random random = new Random();
        for (int i = 0; i < s1.length; i++) {
            s1[i] = (char) (64 + random.nextInt(26));
        }
        for (int i = 0; i < s2.length; i++) {
            s2[i] = (char) (64 + random.nextInt(26));
        }
        //System.out.println(force(s1, s2, 0, 0));
        System.out.println(solution(s1, s2));
    }
}
