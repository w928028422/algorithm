package graph;

import java.util.*;

/**
 * 单源最短路径的dijkstra算法
 */
public class Dijkstra {

    public static Map<Node, Integer> dijkstra(Graph graph, Node node){
        HashMap<Node, Integer> path = new HashMap<>();
        HashSet<Node> visited = new HashSet<>();
        PriorityQueue<Edge> minQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        visited.add(node);
        minQueue.addAll(node.edges);
        for (Node point : graph.nodes.values()){
            if (point != node){
                path.put(point, Integer.MAX_VALUE);
            }else{
                path.put(node, 0);
            }
        }
        for (Edge edge : node.edges){
            path.put(edge.to, edge.weight);
        }
        while (!minQueue.isEmpty()){
            Node minNode =  minQueue.poll().to;
            visited.add(minNode);
            for (Edge edge : minNode.edges) {
                if (!visited.contains(edge.to) && edge.weight != Integer.MAX_VALUE && (path.get(minNode) + edge.weight) < path.get(edge.to)) {
                    path.put(edge.to, path.get(minNode) + edge.weight);
                    minQueue.add(edge);
                }
            }
        }

        return path;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{100,1,6},{30,1,5},{10,1,3},{60,5,6},{20,5,4},{10,4,6},{50,3,4},{5,2,3}};
        Graph graph = GraphFactory.createGraph(matrix);
        Node node = graph.nodes.get(1);
        Map<Node,Integer> path = dijkstra(graph, node);
        for (Map.Entry<Node, Integer> entry : path.entrySet()){
            System.out.println("结点" + node + "与结点" + entry.getKey() + "的最短路径为" + entry.getValue());
        }
    }
}
