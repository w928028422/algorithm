package graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 无向图的最小生成树的kruskal算法
 */
public class KruskalMST {

    public static Set<Edge> kruskal(Graph graph){
        UnionFindSet unionFindSet = new UnionFindSet(graph.nodes.values());
        PriorityQueue<Edge> minEdges = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        Set<Edge> res = new HashSet<>();
        minEdges.addAll(graph.edges);
        while (!minEdges.isEmpty()){
            Edge edge = minEdges.poll();
            if (!unionFindSet.isSameSet(edge.from, edge.to)){
                res.add(edge);
                unionFindSet.union(edge.from, edge.to);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {4,1,2},{3,1,3},{2,2,3},{1,1,4},{5,3,4},{5,2,6},{4,6,5},{2,4,7},{3,5,7},
                {4,2,1},{3,3,1},{2,3,2},{1,4,1},{5,4,3},{5,6,2},{4,5,6},{2,7,4},{3,7,5}
        };
        System.out.println(kruskal(GraphFactory.createGraph(matrix)));
    }
}
