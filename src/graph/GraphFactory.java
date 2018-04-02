package graph;

public class GraphFactory {

    public static Graph createGraph(int[][] matrix){
        Graph graph = new Graph();
        for (int[] aMatrix : matrix) {
            Integer weight = aMatrix[0], from = aMatrix[1], to = aMatrix[2];
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from), toNode = graph.nodes.get(to);
            Edge edge = new Edge(weight, fromNode, toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.nexts.add(toNode);
            fromNode.edges.add(edge);
            graph.edges.add(edge);
        }
        return graph;
    }
}
