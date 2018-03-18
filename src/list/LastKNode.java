package list;

public class LastKNode{

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
