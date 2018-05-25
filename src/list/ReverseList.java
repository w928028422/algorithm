package list;

import java.util.Arrays;

import static list.ListNode.*;

public class ReverseList {

    public static ListNode solution(ListNode head){
        ListNode newHead = null;
        ListNode curHead = head;
        while (curHead != null){
            ListNode temp = curHead.next;
            curHead.next = newHead;
            newHead = curHead;
            curHead = temp;
        }
        return newHead;
    }

    /**
     * 递归法
     */
    public static ListNode reverse(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = createList(Arrays.asList(0,1,2,3,4,5,6,7,8,9,10));
        printList(head);
        ListNode newHead = solution(head);
        printList(newHead);
    }
}
