package list;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 拷贝一个特殊链表，结点中还额外带有一个指向随机元素的指针。
 */
public class CopyListWithRandom {

    static class Node extends ListNode{
        public Node rand;
        public Node next;


        public Node(int data){
            super(data);
            rand = null;
            next = null;
        }
    }

    public static Node solution(Node head){
        Map<Node, Node> nodeMap = new HashMap<>();
        Node cur = head;
        while (cur != null){
            nodeMap.put(cur, new Node(cur.data));
            cur = cur.next;
        }
        cur = head;
        while (cur != null){
            nodeMap.get(cur).next = nodeMap.get(cur.next);
            nodeMap.get(cur).rand = nodeMap.get(cur.rand);
            cur = cur.next;
        }
        return nodeMap.get(head);
    }

    private static void printList(Node head){
        Node cur = head;
        while (cur != null){
            System.out.println(cur.data + " rand: " + cur.rand.data);
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Random random = new Random();
        Node[] nodes = new Node[]{
                new Node(15), new Node(23), new Node(25), new Node(10), new Node(0)
        };
        for (int i = 0; i < nodes.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
            nodes[i].rand = nodes[random.nextInt(nodes.length)];
        }
        nodes[nodes.length - 1].next = null;
        nodes[nodes.length - 1].rand = nodes[random.nextInt(nodes.length)];
        Node head = nodes[0];
        printList(head);
        printList(solution(head));
    }
}
