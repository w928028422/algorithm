package tree;

import static tree.TreeTraversal.createTree;

/**
 * 统计一棵完全二叉树的结点个数，低于O(n)时间复杂度
 */
public class NodeNumInCompleteTree {

    public static int nodeNum(Node root){
        if (root == null){
            return 0;
        }
        return bs(root, 1, height(root, 1));
    }

    private static int bs(Node root, int level, int h) {
        if (level == h){
            return 1;
        }
        if (height(root.right, level + 1) == h){
            return (1 << (h - level)) + bs(root.right, level + 1, h);
        }else{
            return (1 << (h - level - 1)) + bs(root.left, level + 1, h);
        }
    }

    private static int height(Node node, int level) {
        while (node != null){
            level++;
            node = node.left;
        }
        return level - 1;
    }

    public static void main(String[] args) {
        Node[] nodes = new Node[7];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i + 1);
        }
        Node root = createTree(nodes);
        System.out.println(nodeNum(root));
    }
}
