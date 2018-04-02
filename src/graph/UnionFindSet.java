package graph;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

public class UnionFindSet {
    private HashMap<Node, Node> parentMap;
    private HashMap<Node, Integer> sizeMap;

    public UnionFindSet(Node[] nodes) {
        parentMap = new HashMap<>();
        sizeMap = new HashMap<>();
        makeSets(Arrays.asList(nodes));
    }

    public UnionFindSet(Collection<Node> nodes) {
        parentMap = new HashMap<>();
        sizeMap = new HashMap<>();
        makeSets(nodes);
    }

    private void makeSets(Collection<Node> nodes){
        parentMap.clear();
        sizeMap.clear();
        for (Node node : nodes){
            parentMap.put(node, node);
            sizeMap.put(node, 1);
        }
    }

    public Node findRoot(Node node){
        Node parent = parentMap.get(node);
        if (node == parent){
            return node;
        }
        parent = findRoot(parent);
        parentMap.put(node, parent);
        return parent;
    }

    public boolean isSameSet(Node node1, Node node2){
        return findRoot(node1) == findRoot(node2);
    }

    public void union(Node node1, Node node2){
        if (node1 == null || node2 == null){
            return;
        }
        Node root1 = findRoot(node1);
        Node root2 = findRoot(node2);
        if (root1 != root2) {
            int size1 = sizeMap.get(root1);
            int size2 = sizeMap.get(root2);
            if (size1 >= size2) {
                sizeMap.put(root1, size1 + size2);
                parentMap.put(root2, root1);
            } else {
                sizeMap.put(root2, size1 + size2);
                parentMap.put(root1, root2);
            }
        }
    }

    public static void main(String[] args) {
        Node[] nodes = new Node[10];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i);
        }
        UnionFindSet unionFindSet = new UnionFindSet(nodes);
        unionFindSet.union(nodes[0], nodes[1]);
        unionFindSet.union(nodes[4], nodes[5]);
        unionFindSet.union(nodes[1], nodes[5]);
        System.out.println(unionFindSet.isSameSet(nodes[0], nodes[4]));
    }
}
