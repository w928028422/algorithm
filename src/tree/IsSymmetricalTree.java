package tree;

/**
 * 判断一颗二叉树是否对称(和镜像一样)
 */
public class IsSymmetricalTree {

    public static boolean isSymmetrical(Node node1, Node node2) {
        return node1 == null && node2 == null || node1 != null && node2 != null && node1.data == node2.data
                && isSymmetrical(node1.left, node2.right) && isSymmetrical(node1.right, node2.left);
    }

    public static void main(String[] args) {
        int[] data = new int[]{8,6,6,5,7,7,5};
        Node[] nodes = new Node[data.length];
        for (int i = 0; i < data.length; i++) {
            nodes[i] = new Node(data[i]);
        }
        Node root = TreeTraversal.createTree(nodes);
        System.out.println(isSymmetrical(root, root));
    }
}
