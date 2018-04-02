package tree;

import java.util.Arrays;
import java.util.List;

import static tree.TreeTraversal.*;

/**
 * 根据前序遍历和后序遍历的结果重建一颗二叉树
 */
public class ReConstructTree {

    public static Node construct(List<Integer> pre, List<Integer> mid){
        if (pre.size() == 0 || mid.size() == 0){
            return null;
        }
        int root = pre.get(0);
        int rootMidIndex = mid.indexOf(root);
        Node node = new Node(root);
        node.left = construct(pre.subList(1, rootMidIndex + 1), mid.subList(0, rootMidIndex));
        node.right = construct(pre.subList(rootMidIndex + 1, pre.size()), mid.subList(rootMidIndex + 1, mid.size()));
        return node;
    }

    public static void main(String[] args) {
        List<Integer> pre = Arrays.asList(1,2,4,7,3,5,6,8);
        List<Integer> mid = Arrays.asList(4,7,2,1,5,3,8,6);
        Node root = construct(pre, mid);
        preOrderTraversal(root);
        inOrderTraversal(root);
        posOrderTraversal(root);
    }
}
