package array;

/**
 * 京东2019春招编程题：括号匹配
 * 给定一个只包含左右括号的字符串，如果交换且仅交换一次其中的两个字符，得到的结果是括号匹配的，输出yes
 * 思路：用一个数统计左括号，一个数统计右括号，每遍历一个字符时，需要统计求右括号-左括号的差值，并用一个值维护最大值。
 * 最后判断最大差值是不是小于等于1,同时需要满足左括号个数等于右括号个数。
 * 又因为题目交代必须有一次操作，所以左右括号必须大于等于2
 */
public class Brackets {

    public static boolean solution(char[] string){
        int left = 0, right = 0, max = Integer.MIN_VALUE;
        for (char c : string){
            if (c == '('){
                ++left;
            }else{
                ++right;
            }
            max = Math.max(max, right - left);
        }
        if (left == right && max <= 1 && left >= 2){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] tests = new String[]{"())(", "((()))", ")))((("};
        for (String test : tests){
            if (solution(test.toCharArray())){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
}
