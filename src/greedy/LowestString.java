package greedy;

import java.util.Arrays;

public class LowestString {

    public static String solution(String[] strs){
        if (strs == null){
            return null;
        }
        Arrays.sort(strs, (a, b)->(a + b).compareTo(b + a));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            stringBuilder.append(strs[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String[] strs = new String[]{
                "abc", "at", "opl", "aqfd", "mnkq", "ss", "b", "ba"
        };
        System.out.println(solution(strs));
    }
}
