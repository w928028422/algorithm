package greedy;

import java.util.Scanner;

/**
 * 剪绳子问题：把长度为n的绳子剪成m块，让m块的乘积最大
 * 策略：n>=5时尽可能剪长度为3的绳子，剩下长度为4时，剪成2块长度为2的绳子
 */
public class CutRope {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(solution(n));
    }

    private static int solution(int n) {
        if (n <= 1){
            return 0;
        }
        if (n == 2){
            return 1;
        }
        if (n == 3){
            return 2;
        }
        int res = 1, i;
        for (i = n; i > 4; i -= 3) {
            res *= 3;
        }
        res *= i;
        return res;
    }
}
