package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 有重复值的全排列 {
    public static void main(String[] args) {
        int[] nums = {2,2,5};
        System.out.println(solution(nums));
    }

    private static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null){
            return res;
        }
        List<Integer> list = new ArrayList<>();
        if (nums.length == 0){
            res.add(list);
            return res;
        }
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        dfs(res, list, visited, nums);
        return res;
    }

    private static void dfs(List<List<Integer>> res, List<Integer> list, boolean[] visited, int[] nums) {
        int n = nums.length;
        if (list.size() == n){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] || i != 0 && (!visited[i - 1] && nums[i] == nums[i - 1])){
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            dfs(res, list, visited, nums);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
