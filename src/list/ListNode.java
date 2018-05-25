package list;

import java.util.List;

public class ListNode {
    public int data;
    public ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "data=" + data +
                '}';
    }

    public static ListNode createList(List<Integer> data){
        if (data.isEmpty()){
            return null;
        }
        ListNode head = new ListNode(data.get(0));
        head.next = createList(data.subList(1, data.size()));
        return head;
    }

    public static void printList(ListNode head){
        while (head != null){
            System.out.print(head);
            System.out.print(" ");
            head = head.next;
        }
        System.out.println();
    }
}
