package search;

/**
 * 打印从1到最大的n位数
 */
public class Print1ToMaxNDigits {

    public static void printNumber(char[] num){
        boolean begin0 = true;
        for (int i = 0; i < num.length; i++) {
            if (begin0 && num[i] != '0'){
                begin0 = false;
            }
            if (!begin0){
                System.out.print(num[i]);
            }
        }
        System.out.printf("\t");
    }

    public static void print1ToN(int n){
        if (n <= 0){
            return;
        }
        char[] num = new char[n];
        for (int i = 0; i < 10; i++) {
            num[0] = (char) ('0' + i);
            process(num, i, n);
        }
    }

    public static void process(char[] num, int index, int n) {
        if (index == n - 1){
            printNumber(num);
            return;
        }
        for (int i = 0; i < 10; i++) {
            num[index + 1] = (char) (i + '0');
            process(num, index + 1, n);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 9;
        print1ToN(n);
    }
}
