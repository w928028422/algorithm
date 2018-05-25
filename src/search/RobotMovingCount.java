package search;

/**
 * 有一个m行n列的方格，机器人从(0,0)开始移动,可以向四方移动，
 * 但不能进入行坐标和列坐标数位之和大于k的格子,机器人最多能进入多少格子
 */
public class RobotMovingCount {

    public static int solution(int k, int m, int n){
        if (m <= 0 || n <= 0 || k < 0){
            throw new RuntimeException("参数不合法");
        }
        boolean[][] visited = new boolean[m][n];
        return movingCount(k, m, n, 0, 0, visited);
    }

    private static int movingCount(int k, int m, int n, int row, int col, boolean[][] visited) {
        if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]
                && getDigitSum(row) + getDigitSum(col) <= k){
            visited[row][col] = true;
            return 1 + movingCount(k, m, n, row + 1, col, visited)
                    + movingCount(k, m, n, row, col + 1, visited)
                    + movingCount(k, m, n, row - 1, col, visited)
                    + movingCount(k, m, n, row, col - 1, visited);
        }
        return 0;
    }

    private static int getDigitSum(int num) {
        int sum = 0;
        while (num != 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int m = 30, n = 30, k = 17;
        System.out.println(solution(k, m, n));
    }
}
