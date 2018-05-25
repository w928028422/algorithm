package other;

/**
 * 数值的整数次方
 */
public class Power {

    public static double power(double base, int exp){
        if (Double.compare(base, 0.0) == 0 && exp < 0){
            throw new RuntimeException("0的负数次方无意义");
        }
        double res = 1.0;
        for (int i = 1; i <= Math.abs(exp); i++) {
            res *= base;
        }
        if (exp < 0){
            res = 1.0 / res;
        }
        return res;
    }

    public static void main(String[] args) {
        double base = 1.7;
        int exp = 4;
        System.out.println(power(base, exp));
    }
}
