package search;

import java.util.ArrayList;
import java.util.List;

public class 全排列 {

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,4};
        System.out.println(solution(nums));
    }

    public static List<List<Integer>> solution(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null){
            return res;
        }
        List<Integer> list = new ArrayList<>();
        if (nums.length == 0){
            res.add(list);
            return res;
        }
        dfs(res, list, nums);
        return res;
    }

    private static void dfs(List<List<Integer>> res, List<Integer> list, int[] nums) {
        int n = nums.length;
        if (list.size() == n){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            dfs(res, list, nums);
            list.remove(list.size() - 1);
        }
    }
}
