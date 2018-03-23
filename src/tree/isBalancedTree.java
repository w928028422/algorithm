package tree;

import static tree.TreeTraversal.createTree;

public class isBalancedTree {

    static class Result{
        public boolean isBalanced;
        public int height;

        public Result() {
            this.isBalanced = true;
            this.height = 0;
        }
    }

    public static Result solution(Node root){
        Result result = new Result();
        if (root == null){
            return result;
        }
        Result left = solution(root.left), right = solution(root.right);
        result.isBalanced = left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) <= 1;
        result.height = Math.max(left.height, right.height) + 1;
        return result;
    }

    public static void main(String[] args) {
        Node[] nodes = new Node[7];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i + 1);
        }
        Node root = createTree(nodes);
        System.out.println(solution(root).isBalanced);
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i + 1);
        }
        for (int i = 0; i < nodes.length - 1; i++) {
            nodes[i].right = nodes[i + 1];
        }
        System.out.println(solution(nodes[0]).isBalanced);
    }
}
