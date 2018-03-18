package list;

public class ReverseList {

    public static ListNode solution(ListNode head){
        if (head == null){
            return head;
        }
        ListNode res = new ListNode(-1);
        ListNode first, temp;
        res.next = head;
        first = res.next;
        while (first.next != null){
            temp = first.next;
            first.next = temp.next;
            temp.next = res.next;
            res.next = temp;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0), temp = head;
        head.next = null;
        for (int i = 0; i < 10; i++) {
            ListNode node = new ListNode(i + 1);
            System.out.print(node.data + " ");
            temp.next = node;
            temp = node;
        }
        System.out.println();
        temp.next = null;
        ListNode iter = solution(head);
        while (iter != null){
            System.out.print(iter.data + " ");
            iter = iter.next;
        }
    }
}
