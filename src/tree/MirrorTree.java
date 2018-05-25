package tree;

import static tree.TreeTraversal.createTree;
import static tree.TreeTraversal.preOrderTraversal;

/**
 * 求一颗二叉树的镜像
 */
public class MirrorTree {

    public static void mirror(Node root){
        if (root == null){
            return;
        }
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null){
            mirror(root.left);
        }
        if (root.right != null){
            mirror(root.right);
        }
    }

    public static void main(String[] args) {
        Node[] nodes = new Node[7];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i + 1);
        }
        Node root = createTree(nodes);
        preOrderTraversal(root);
        mirror(root);
        preOrderTraversal(root);
    }
}
