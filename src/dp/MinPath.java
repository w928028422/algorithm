package dp;

import java.util.Random;

public class MinPath {

    /**
     * 递归版本
     * @param matrix 二维矩阵
     * @param i 当前走到的行
     * @param j 当前走到的列
     * @return 最短布数
     */
    public static int walk(int[][] matrix, int i, int j){
        int m = matrix.length, n = matrix[0].length;
        if (i == m - 1 && j == n - 1){
            return matrix[i][j];
        }
        if (i == m - 1){
            return matrix[i][j] + walk(matrix, i , j + 1);
        }
        if (j == n - 1){
            return matrix[i][j] + walk(matrix, i + 1, j);
        }
        return matrix[i][j] + Math.min(walk(matrix, i + 1, j), walk(matrix, i, j +1));
    }

    /**
     * 动态规划法
     */
    public static int dp(int[][] matrix){
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = matrix[m - 1][n - 1];
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = matrix[i][n - 1] + dp[i + 1][n - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            dp[m - 1][i] = matrix[m - 1][i] + dp[m - 1][i + 1];
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] matrix = new int[4][5];
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = random.nextInt(10);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(walk(matrix, 0, 0));
        System.out.println(dp(matrix));
    }
}
