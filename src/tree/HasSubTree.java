package tree;

import static tree.TreeTraversal.*;

public class HasSubTree {

    public static boolean hasSubTree(Node root1, Node root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        boolean result = false;
        if (root1.data == root2.data){
            result = DoesTree1HasTree2(root1, root2);
        }
        if (!result){
            result = hasSubTree(root1.left, root2) || hasSubTree(root1.right, root2);
        }
        return result;
    }

    private static boolean DoesTree1HasTree2(Node root1, Node root2) {
        return root2 == null || root1 != null && root1.data == root2.data && DoesTree1HasTree2(root1.left, root2.left) && DoesTree1HasTree2(root1.right, root2.right);
    }

    public static void main(String[] args) {
        Node[] nodes = new Node[7];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i + 1);
        }
        Node root1 = createTree(nodes);
        Node root2 = new Node(3, new Node(6), null);
        System.out.println(hasSubTree(root1, root2));
    }
}
