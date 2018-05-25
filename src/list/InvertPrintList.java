package list;

import java.util.Arrays;
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
        int k = 9;
        ListNode head = ListNode.createList(Arrays.asList(0,1,2,3,4,5,6,7,8,9,10));
        print(head);
    }
}
