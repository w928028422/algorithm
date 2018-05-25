package list;

import java.util.Arrays;

/**
 * O(1)时间内删除链表的一个节点
 */
public class DeleteNode {

    public static void deleteNode(ListNode head, ListNode node){
        if (head == null || node == null){
            return;
        }
        //要删除的不是尾节点，把下一个节点的内容复制到node里，调整node的next指针，删除node的下一个结点
        if (node.next != null){
            ListNode next = node.next;
            node.next = next.next;
            node.data = next.data;
        }else{
            ListNode cur = head;
            while (cur.next != node){
                cur = cur.next;
            }
            cur.next = null;
        }
    }

    public static void main(String[] args) {
        int k = 9;
        ListNode head = ListNode.createList(Arrays.asList(0,1,2,3,4,5,6,7,8,9,10));
        deleteNode(head, head.next);
        ListNode.printList(head);
    }
}
