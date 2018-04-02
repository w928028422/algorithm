package graph;

import java.util.*;

/**
 * 有向无环图的拓扑排序
 */
public class TopologySort {

    public static List<Node> sort(Graph graph){
        HashMap<Node, Integer> inMap = new HashMap<>();
        Queue<Node> zeroInQueue = new LinkedList<>();
        List<Node> res = new ArrayList<>();
        for (Node node : graph.nodes.values()){
            inMap.put(node, node.in);
            if (node.in == 0){
                zeroInQueue.add(node);
            }
        }
        while (!zeroInQueue.isEmpty()){
            Node cur = zeroInQueue.poll();
            res.add(cur);
            for (Node next : cur.nexts){
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0){
                    zeroInQueue.add(next);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
          int[][] matrix = new int[][]{{0,2,1},{0,3,2},{0,4,1},{0,5,2},{0,5,4}};
          List<Node> nodes = sort(GraphFactory.createGraph(matrix));
          System.out.println(nodes);
    }
}
