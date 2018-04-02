package graph;

import java.util.HashSet;
import java.util.Stack;

public class DFS {

    public static void dfs(Node node){
        if (node == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.push(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.empty()){
            Node cur = stack.pop();
            for (Node next : cur.nexts){
                if (!set.contains(next)){
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0,1,2},{1,1,3},{2,1,4},{2,2,5},{2,2,6},{3,5,6},{2,6,7},{3,3,8},{3,3,4},{4,4,9}
        };
        Node nodeFirst = GraphFactory.createGraph(matrix).nodes.get(1);
        dfs(nodeFirst);
    }
}
