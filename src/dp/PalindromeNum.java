package dp;

/**
 * 京东2019春招编程题：回文串的数目
 * 输入一个字符串，可以移除0到n个字符，移除的字符不重复的情况下能组成多少回文串
 * dp[l][r]表示区间 [l, r] 内的回文串数目。
 * 于是dp[l][r] = dp[l][r - 1] + dp[l + 1][r]
 * 根据s[l] ?= s[r], 来看是+1还是减掉重复的部分
 */
public class PalindromeNum {

    public static int solution(char[] str){
        int n = str.length;
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1];
                    if (str[i] == str[j]){
                        ++dp[i][j];
                    }else{
                        dp[i][j] -= dp[i + 1][j - 1];
                    }
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        String test = "ABABABABABA";
        System.out.println(solution(test.toCharArray()));
    }
}
