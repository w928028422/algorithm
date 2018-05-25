package list;

import java.util.Arrays;

import static list.ListNode.*;

/**
 * 合并两个排序的链表
 */
public class MergeSortedList {


    public static ListNode merge(ListNode head1, ListNode head2){
        if (head1 == null || head2 == null){
            return null;
        }
        ListNode newHead, cur;
        if (head1.data < head2.data){
            newHead = head1;
            head1 = head1.next;
        }else{
            newHead = head2;
            head2 = head2.next;
        }
        cur = newHead;
        while (head1 != null && head2 != null){
            if (head1.data < head2.data){
                cur.next = head1;
                cur = cur.next;
                head1 = head1.next;
            }else{
                cur.next = head2;
                cur = cur.next;
                head2 = head2.next;
            }
        }
        while (head1 != null){
            cur.next = head1;
            cur = cur.next;
            head1 = head1.next;
        }
        while (head2 != null){
            cur.next = head2;
            cur = cur.next;
            head2 = head2.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head1 = createList(Arrays.asList(1,3,5,7,9));
        ListNode head2 = createList(Arrays.asList(2,4,6,8,10,12,14));
        ListNode newHead = merge(head1, head2);
        printList(newHead);
    }
}
