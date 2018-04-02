package search;

/**
 * 判断在一个矩阵中是否存在一条包含字符串全部字符的路径
 */
public class MatrixHasPath {

    public static boolean solution(char[][] matrix, char[] str){
        if (matrix == null || str == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (hasPath(matrix, visited, str, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasPath(char[][] matrix, boolean[][] visited, char[] str, int row, int col, int length) {
        if (length == str.length){
            return true;
        }
        boolean hasPath = false;
        if (row < matrix.length && row >= 0 && col < matrix[0].length && col >= 0
                && str[length] == matrix[row][col] && !visited[row][col]){
            visited[row][col] = true;
            ++length;
            hasPath = hasPath(matrix, visited, str, row + 1, col, length)
                    || hasPath(matrix, visited, str, row - 1, col, length)
                    || hasPath(matrix, visited, str, row, col + 1, length)
                    || hasPath(matrix, visited, str, row, col - 1, length);
            if (!hasPath){
                --length;
                visited[row][col] = false;
            }
        }
        return hasPath;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[10][12];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = (char)(Math.random() * 26 + 65);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(solution(matrix, "AZ".toCharArray()));
    }
}
