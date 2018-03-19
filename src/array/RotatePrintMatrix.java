package array;

import java.util.ArrayList;
import java.util.List;

public class RotatePrintMatrix {

    public static List<Integer> solution(int[][] matrix){
        List<Integer> res = new ArrayList<>();
        int tR = 0, tC = 0, dR = matrix.length - 1, dC = matrix[0].length - 1;
        while (tR <= dR && tC <= dC){
            printEdge(matrix, res, tR++, tC++, dR--, dC--);
        }
        return res;
    }

    private static void printEdge(int[][] matrix, List<Integer> res, int tR, int tC, int dR, int dC) {
        int curTr = tR, curTc = tC;
        if (tR == dR){
            while (curTc <= dC){
                res.add(matrix[tR][curTc++]);
            }
        }else if (tC == dC){
            while (curTr <= dR){
                res.add(matrix[curTr++][tC]);
            }
        }else {
            while (curTc != dC){
                res.add(matrix[tR][curTc++]);
            }
            while (curTr != dR){
                res.add(matrix[curTr++][dC]);
            }
            while (curTc != tC){
                res.add(matrix[dR][curTc--]);
            }
            while (curTr != tR){
                res.add(matrix[curTr--][tC]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        for (int[] mt : matrix){
            for (int m : mt){
                System.out.print(m + " ");
            }
            System.out.println();
        }
        System.out.println(solution(matrix));
    }
}
