package array;

/**
 * 二维数组的查找，一列从上到下升序，一行从左到右升序
 */
public class FindInMatrix {

    public static boolean find(int[][] matrix, int target){
        int rows = matrix.length, row = 0, col = matrix[0].length - 1;
        while (row < rows && col >= 0){
            if (matrix[row][col] == target){
                return true;
            }
            if (matrix[row][col] < target){
                row++;
            } else{
                col--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matrix[i][j] = i * 10 + j;
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        int target = (int) (Math.random() * 100);
        System.out.println(target);
        System.out.println(find(matrix, target));
    }
}
