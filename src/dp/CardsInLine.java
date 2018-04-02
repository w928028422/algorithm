package dp;

/**
 * 有一排卡片标记着分数，甲乙两个人轮流拿走一个，每次只能拿最左或最右的，假设两个人都足够聪明，问甲乙中获胜者的最大分数是多少
 */
public class CardsInLine {

    public static int win(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        return Math.max(xian(arr, 0, arr.length - 1), hou(arr, 0, arr.length - 1));
    }

    /**
     * 先手操作
     */
    public static int xian(int[] arr, int i, int j){
        if (i == j){
            return arr[i];
        }
        return Math.max(arr[i] + hou(arr, i + 1, j), arr[j] + hou(arr, i, j - 1));
    }

    /**
     * 后手操作，先手方一定会留给我最小的选择
     */
    public static int hou(int[] arr, int i, int j){
        if (i == j){
            return 0;
        }
        return Math.min(xian(arr, i + 1, j), xian(arr, i, j - 1));
    }

    public static int dp(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        int n = arr.length;
        int[][] xian = new int[n][n];
        int[][] hou = new int[n][n];
        for (int i = 0; i < n; i++) {
            xian[i][i] = arr[i];
        }
        for (int t = 1; t < n; t++) {
            for (int j = t, i = 0; i < n - t; j++, i++) {
                xian[i][j] = Math.max(arr[j] + hou[i][j - 1], arr[i] + hou[i + 1][j]);
                hou[i][j] = Math.min(xian[i][j - 1], xian[i + 1][j]);
            }
        }
        return Math.max(xian[0][n - 1], hou[0][n - 1]);
    }

    public static void main(String[] args) {
        int[] arr = {40,25,36,80,50,0,25,60};
        System.out.println(win(arr));
        System.out.println(dp(arr));
    }
}
