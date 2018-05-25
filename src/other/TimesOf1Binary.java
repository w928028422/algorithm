package other;

/**
 * 二进制中1的个数
 */
public class TimesOf1Binary {

    /**
     * 方案一：flag刚开始为1，每次与num做与运算，然后左移一位，直至flag为0
     */
    public static int solution1(int num){
        int res = 0, flag = 1;
        while (flag != 0){
            if ((num & flag) != 0){
                res++;
            }
            flag <<= 1;
        }
        return res;
    }

    /**
     * 方案二：一个数减去1就会把二进制中最右的1置为0，后面的0置为1，再和原数做与运算会把最右的那个1变成0，如此往复
     */
    public static int solution2(int num){
        int res = 0;
        while (num != 0){
            res++;
            num = (num - 1) & num;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 32767;
        System.out.println(solution1(n));
        System.out.println(solution2(n));
    }
}
