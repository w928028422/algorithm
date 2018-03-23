package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 之字形打印矩阵
 */
public class ZigZagPrintMatrix {

    public static List<Integer> solution(int[][] matrix){
        List<Integer> res = new ArrayList<>();
        int aR = 0, aC = 0, bR = 0, bC = 0;
        int endR = matrix.length - 1, endC = matrix[0].length - 1;
        boolean fromUp = false;
        while (aR != endR + 1){
            printLevel(matrix, aR, aC, bR, bC, fromUp, res);
            aR = aC == endC ? aR + 1 : aR;
            aC = aC == endC ? aC : aC + 1;
            bC = bR == endR ? bC + 1 : bC;
            bR = bR == endR ? bR : bR + 1;
            fromUp = !fromUp;
        }
        return res;
    }

    private static void printLevel(int[][] matrix, int aR, int aC, int bR, int bC, boolean fromUp, List<Integer> res) {
        if (fromUp){
            while (aR != bR + 1){
                res.add(matrix[aR++][aC--]);
            }
        }else{
            while (bR != aR - 1){
                res.add(matrix[bR--][bC++]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        for (int[] mt : matrix){
            for (int m : mt){
                System.out.print(m + " ");
            }
            System.out.println();
        }
        System.out.println(solution(matrix));
    }
}
