package graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 无向图的最小生成树的Prim算法
 */
public class PrimMST {

    public static Set<Edge> prim(Graph graph){
        PriorityQueue<Edge> minQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        Set<Node> set = new HashSet<>();
        Set<Edge> res = new HashSet<>();
        for (Node node : graph.nodes.values()){
            if (!set.contains(node)){
                set.add(node);
                minQueue.addAll(node.edges);
                while (!minQueue.isEmpty()){
                    Edge edge = minQueue.poll();
                    Node toNode = edge.to;
                    if (!set.contains(toNode)){
                        set.add(toNode);
                        res.add(edge);
                        minQueue.addAll(toNode.edges);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {4,1,2},{3,1,3},{2,2,3},{1,1,4},{5,3,4},{5,2,6},{4,6,5},{2,4,7},{3,5,7},
                {4,2,1},{3,3,1},{2,3,2},{1,4,1},{5,4,3},{5,6,2},{4,5,6},{2,7,4},{3,7,5}
        };
        System.out.println(prim(GraphFactory.createGraph(matrix)));
    }
}

