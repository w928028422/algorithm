package list;

import org.junit.Test;

/**
 * 判断两个单链表是否相交，如果相交找到第一个交点
 * 注意：分情况考虑，先判断两个链表是否有环
 */
public class FindFirstIntersectNode {

    /**
     * 判断是否有环
     * @return 如果有环，返回进入环的第一个结点，否则返回null
     */
    public static ListNode getLoopNode(ListNode head){
        if (head == null || head.next == null){
            return null;
        }
        ListNode fast = head.next.next, slow = head.next;
        while (fast != slow){
            if (fast == null || fast.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static ListNode getIntersectNode(ListNode head1, ListNode head2){
        if (head1 == null || head2 == null){
            return null;
        }
        ListNode loop1 = getLoopNode(head1), loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null){
            return noLoop(head1, head2);
        }else if (loop1 != null && loop2 != null){
            return bothLoop(head1, head2, loop1, loop2);
        }
        return null;
    }

    private static ListNode bothLoop(ListNode head1, ListNode head2, ListNode loop1, ListNode loop2) {
        if (loop1 == loop2){
            ListNode cur1 = head1, cur2= head2;
            int n = 0;
            while (cur1.next != loop1){
                n++;
                cur1 = cur1.next;
            }
            while (cur2.next != loop2){
                n--;
                cur2 = cur2.next;
            }
            if (cur1 != cur2){
                return null;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0){
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }
        ListNode cur = loop1.next;
        while (cur != loop1){
            if (cur == loop2){
                return loop1;
            }
            cur = cur.next;
        }
        return null;
    }

    private static ListNode noLoop(ListNode head1, ListNode head2) {
        ListNode cur1 = head1, cur2= head2;
        int n = 0;
        while (cur1.next != null){
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null){
            n--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2){
            return null;
        }
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        while (n != 0){
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    /**
     * 测试都无环相交的情况
     */
    @Test
    public void TestNoLoop1(){
        ListNode[] nodes1 = new ListNode[]{
                new ListNode(1), new ListNode(2), new ListNode(3), new ListNode(4)
        };
        ListNode[] nodes2 = new ListNode[]{
                new ListNode(0), new ListNode(8), new ListNode(15), nodes1[2], nodes1[3]
        };
        for (int i = 0; i < nodes1.length - 1; i++) {
            nodes1[i].next = nodes1[i + 1];
        }
        nodes1[nodes1.length - 1].next = null;
        for (int i = 0; i < nodes2.length - 1; i++) {
            nodes2[i].next = nodes2[i + 1];
        }
        nodes2[nodes2.length - 1].next = null;
        System.out.println(getIntersectNode(nodes1[0], nodes2[0]));
    }

    /**
     * 测试都无环不相交的情况
     */
    @Test
    public void TestNoLoop2(){
        ListNode[] nodes1 = new ListNode[]{
                new ListNode(1), new ListNode(2), new ListNode(3), new ListNode(4)
        };
        ListNode[] nodes2 = new ListNode[]{
                new ListNode(0), new ListNode(8), new ListNode(15)
        };
        for (int i = 0; i < nodes1.length - 1; i++) {
            nodes1[i].next = nodes1[i + 1];
        }
        nodes1[nodes1.length - 1].next = null;
        for (int i = 0; i < nodes2.length - 1; i++) {
            nodes2[i].next = nodes2[i + 1];
        }
        nodes2[nodes2.length - 1].next = null;
        System.out.println(getIntersectNode(nodes1[0], nodes2[0]));
    }

    /**
     * 测试都有环不相交的情况
     */
    @Test
    public void TestBothLoop1(){
        ListNode[] nodes1 = new ListNode[]{
                new ListNode(1), new ListNode(2), new ListNode(3), new ListNode(4)
        };
        ListNode[] nodes2 = new ListNode[]{
                new ListNode(0), new ListNode(8), new ListNode(15), new ListNode(20)
        };
        for (int i = 0; i < nodes1.length - 1; i++) {
            nodes1[i].next = nodes1[i + 1];
        }
        nodes1[nodes1.length - 1].next = nodes1[1];
        for (int i = 0; i < nodes2.length - 1; i++) {
            nodes2[i].next = nodes2[i + 1];
        }
        nodes2[nodes2.length - 1].next = nodes2[1];
        System.out.println(getIntersectNode(nodes1[0], nodes2[0]));
    }

    /**
     * 测试都有环,在环上相交的情况
     */
    @Test
    public void TestBothLoop2(){
        ListNode[] nodes1 = new ListNode[]{
                new ListNode(1), new ListNode(2), new ListNode(9), new ListNode(4), new ListNode(5)
        };
        ListNode[] nodes2 = new ListNode[]{
                new ListNode(10), new ListNode(0), new ListNode(8), nodes1[3], nodes1[4], nodes1[2]
        };
        for (int i = 0; i < nodes1.length - 1; i++) {
            nodes1[i].next = nodes1[i + 1];
        }
        nodes1[nodes1.length - 1].next = nodes1[2];
        for (int i = 0; i < nodes2.length - 1; i++) {
            nodes2[i].next = nodes2[i + 1];
        }
        nodes2[nodes2.length - 1].next = nodes2[3];
        System.out.println(getIntersectNode(nodes1[0], nodes2[0]));
    }

    /**
     * 测试都有环,在环外相交的情况
     */
    @Test
    public void TestBothLoop3(){
        ListNode[] nodes1 = new ListNode[]{
                new ListNode(1), new ListNode(2), new ListNode(7), new ListNode(4), new ListNode(5), new ListNode(6)
        };
        ListNode[] nodes2 = new ListNode[]{
                new ListNode(10), new ListNode(0), new ListNode(8), nodes1[2], nodes1[3], nodes1[4], nodes1[5]
        };
        for (int i = 0; i < nodes1.length - 1; i++) {
            nodes1[i].next = nodes1[i + 1];
        }
        nodes1[nodes1.length - 1].next = nodes1[3];
        for (int i = 0; i < nodes2.length - 1; i++) {
            nodes2[i].next = nodes2[i + 1];
        }
        System.out.println(getIntersectNode(nodes1[0], nodes2[0]));
    }
}
