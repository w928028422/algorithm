package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 要做k个项目，每次只能同时做一个项目，现在有每个项目的花费cost[]，和每个项目的收益profit[]，求做k个项目的最大收益
 */
public class IPO {

    public static class Project{
        int cost;
        int profit;

        public Project(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }
    }

    public static int findMaximizedCost(int k, int w, int[] costs, int[] profits){
        Project[] projects = new Project[costs.length];
        for (int i = 0; i < costs.length; i++) {
            projects[i] = new Project(costs[i], profits[i]);
        }
        PriorityQueue<Project> minQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        PriorityQueue<Project> maxQueue = new PriorityQueue<>((a, b)->b.profit - a.profit);
        minQueue.addAll(Arrays.asList(projects));
        for (int i = 0; i < k; i++) {
            while (!minQueue.isEmpty() && minQueue.peek().cost <= w){
                maxQueue.add(minQueue.poll());
            }
            if (maxQueue.isEmpty()){
                return w;
            }
            w += maxQueue.poll().profit;
        }
        return w;
    }

    public static void main(String[] args) {
        int[] costs = new int[]{7,4,5,8,15,25};
        int[] profits = new int[]{3,2,4,5,9,15};
        System.out.println(findMaximizedCost(3, 7, costs, profits));
    }
}
