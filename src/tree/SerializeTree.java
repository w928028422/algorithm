package tree;

import java.util.LinkedList;
import java.util.Queue;

import static tree.TreeTraversal.createTree;
import static tree.TreeTraversal.preOrderTraversal;

public class SerializeTree {

    public static String serializePreOrder(Node node){
        if (node == null){
            return "#!";
        }
        String res = node.data + "!";
        res += serializePreOrder(node.left);
        res += serializePreOrder(node.right);
        return res;
    }

    public static Node reConstructTree(String tree){
        String[] nodes = tree.split("!");
        Queue<String> queue = new LinkedList<>();
        for (String node : nodes){
            queue.offer(node);
        }
        return reConstructPreOrder(queue);
    }

    private static Node reConstructPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")){
            return null;
        }
        Node node = new Node(Integer.valueOf(value));
        node.left = reConstructPreOrder(queue);
        node.right = reConstructPreOrder(queue);
        return node;
    }

    public static void main(String[] args) {
        Node[] nodes = new Node[7];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i + 1);
        }
        Node root = createTree(nodes);
        String tree = serializePreOrder(root);
        System.out.println(tree);
        root = reConstructTree(tree);
        preOrderTraversal(root);
    }
}
