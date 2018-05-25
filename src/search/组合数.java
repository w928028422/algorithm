package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组和要取的数n，打印所有的组合
 */
public class 组合数 {

    public static void solution(List<Integer> selected, List<Integer> data, int n){
        if (n == 0){
            for (int s : selected){
                System.out.print(s + " ");
            }
            System.out.println();
            return;
        }
        if (data.isEmpty()){
            return;
        }
        selected.add(data.get(0));
        solution(selected, data.subList(1, data.size()), n - 1);
        selected.remove(selected.size() - 1);
        solution(selected, data.subList(1, data.size()), n);
    }

    public static void main(String[] args) {
        solution(new ArrayList<>(), Arrays.asList(1,4,5,7,8), 0);
    }
}
