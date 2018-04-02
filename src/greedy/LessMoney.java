package greedy;

import java.util.PriorityQueue;

/**
 * 类似哈夫曼编码的过程
 */
public class LessMoney {

    public static int solution(int[] moneys){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int money : moneys){
            queue.add(money);
        }
        int sum = 0, cur;
        while (queue.size() > 1){
            cur = queue.poll() + queue.poll();
            sum += cur;
            queue.add(cur);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] moneys = new int[]{1,3,2,5,6,18,20,9};
        System.out.println(solution(moneys));
    }
}
