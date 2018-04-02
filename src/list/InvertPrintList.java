package list;

import java.util.Stack;

/**
 * 逆序打印链表
 */
public class InvertPrintList {

    public static void print(ListNode head){
        ListNode cur = head;
        Stack<ListNode> stack = new Stack<>();
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while (!stack.empty()){
            System.out.print(stack.pop().data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0), temp = head;
        int k = 9;
        head.next = null;
        System.out.print(head.data + " ");
        for (int i = 0; i < 10; i++) {
            ListNode node = new ListNode(i + 1);
            System.out.print(node.data + " ");
            temp.next = node;
            temp = node;
        }
        System.out.println();
        print(head);
    }
}
