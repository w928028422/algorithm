package tree;

import static tree.TreeTraversal.createTree;

public class SuccessorNode {

    public static Node getSuccessorNode(Node node){
        if (node == null){
            return null;
        }
        if (node.right != null){
            return getLeftMost(node.right);
        }
        Node parent = node.parent;
        while (parent != null && parent.left != node){
            node = parent;
            parent = node.parent;
        }
        return parent;
    }

    public static Node getLeftMost(Node node) {
        while (node.left != null){
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        Node[] nodes = new Node[7];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i + 1);
        }
        Node root = createTree(nodes);
        System.out.println(getSuccessorNode(root).data);
        System.out.println(getSuccessorNode(root.left.right).data);
    }
}
