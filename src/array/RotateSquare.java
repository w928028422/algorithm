package array;

/**
 * 将一个正方形矩阵顺时针旋转90度
 */
public class RotateSquare {

    public static void solution(int[][] matrix){
        int tR = 0, tC = 0, dR = matrix.length - 1, dC = matrix[0].length - 1;
        while (tR < dR){
            rotateEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    private static void rotateEdge(int[][] matrix, int tR, int tC, int dR, int dC) {
        int times = dC - tC, tmp = 0;
        for (int i = 0; i != times; i++) {
            tmp = matrix[tR][tC + i];
            matrix[tR][tC + i] = matrix[dR - i][tC];
            matrix[dR - i][tC] = matrix[dR][dC - i];
            matrix[dR][dC - i] = matrix[tR + i][dC];
            matrix[tR + i][dC] = tmp;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        for (int[] mt : matrix){
            for (int m : mt){
                System.out.print(m + " ");
            }
            System.out.println();
        }
        solution(matrix);
        for (int[] mt : matrix){
            for (int m : mt){
                System.out.print(m + " ");
            }
            System.out.println();
        }
    }
}
