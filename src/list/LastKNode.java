package list;

import java.util.Arrays;

public class LastKNode{

    public static void main(String[] args) {
        int k = 9;
        ListNode head = ListNode.createList(Arrays.asList(0,1,2,3,4,5,6,7,8,9,10));
        ListNode res = solution(head, k);
        System.out.println(res != null ? res.data : "没有对应的结点!");
    }

    public static ListNode solution(ListNode head, int k){
        if (k <= 0 || head == null){
            return null;
        }
        ListNode fast = head, slow = head;
        while (k-- > 0 && fast != null){
            fast = fast.next;
        }
        if (fast == null){
            return null;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
