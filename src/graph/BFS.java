package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static void bfs(Node node){
        if (node == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next : cur.nexts){
                if (!set.contains(next)){
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0,1,2},{1,1,3},{2,1,4},{2,2,5},{2,2,6},{3,5,6},{2,6,7},{3,3,8},{3,3,4},{4,4,9}
        };
        Node nodeFirst = GraphFactory.createGraph(matrix).nodes.get(1);
        bfs(nodeFirst);
    }
}
