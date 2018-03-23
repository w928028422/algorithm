package tree;

import java.util.LinkedList;
import java.util.Queue;

import static tree.TreeTraversal.createTree;

public class isCompleteTree {

    public static boolean solution(Node root){
        if (root == null){
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        Node node, l, r;
        boolean leaf = false;
        queue.offer(root);
        while (!queue.isEmpty()){
            node = queue.poll();
            l = node.left;
            r = node.right;
            if ((l == null && r != null) || (leaf && (l != null || r != null))){
                return false;
            }
            if (l != null){
                queue.offer(l);
            }
            if (r != null){
                queue.offer(r);
            }else{
                leaf = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Node[] nodes = new Node[7];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i + 1);
        }
        Node root = createTree(nodes);
        System.out.println(solution(root));
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i + 1);
        }
        for (int i = 0; i < nodes.length - 1; i++) {
            nodes[i].right = nodes[i + 1];
        }
        System.out.println(solution(nodes[0]));
    }

}
