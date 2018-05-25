package tree;

import java.util.Stack;

/**
 * 二叉树的遍历非递归实现
 */
public class TreeTraversal {

    public static void preOrderTraversal(Node root){
        if (root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        stack.push(cur);
        while (!stack.empty()){
            cur = stack.pop();
            System.out.print(cur.data + " ");
            if (cur.right != null){
                stack.push(cur.right);
            }
            if (cur.left != null){
                stack.push(cur.left);
            }
        }
        System.out.println();
    }

    public static void inOrderTraversal(Node root){
        if (root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (!stack.empty() || cur != null){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                System.out.print(cur.data + " ");
                cur = cur.right;
            }
        }

        System.out.println();
    }

    public static void posOrderTraversal(Node root){
        if (root == null){
            return;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        Node cur = root;
        stack1.push(cur);
        while (!stack1.empty()){
            cur = stack1.pop();
            stack2.push(cur);
            if (cur.left != null){
                stack1.push(cur.left);
            }
            if (cur.right != null){
                stack1.push(cur.right);
            }
        }
        while (!stack2.empty()){
            System.out.print(stack2.pop().data + " ");
        }
        System.out.println();
    }

    public static Node createTree(Node[] nodes){
        int n = nodes.length;
        for (int i = 0; i < n / 2 - 1; i++) {
             nodes[i].left = nodes[2 * i + 1];
             nodes[i].right = nodes[2 * i + 2];
        }
        nodes[n / 2 - 1].left = nodes[n / 2 * 2 - 1];
        if (n % 2 == 1){
            nodes[n / 2 - 1].right = nodes[n - 1];
        }
        for (int i = 1; i < n; i++) {
            nodes[i].parent = nodes[(i - 1) / 2];
        }
        return nodes[0];
    }

    public static void main(String[] args) {
        Node[] nodes = new Node[7];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i + 1);
        }
        Node root = createTree(nodes);
        preOrderTraversal(root);
        inOrderTraversal(root);
        posOrderTraversal(root);
    }
}
