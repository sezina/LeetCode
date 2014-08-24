/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode head1 = null, tail1 = null, head2 = null, tail2 = null, traversal = head;
        if (head.val < x) tail1 = head1 = head;
        else tail2 = head2 = head;
        while (traversal.next != null) {
            if (traversal.next.val < x) {
                if (head1 == null)
                    tail1 = head1 = traversal.next;
                else {
                    tail1.next = traversal.next;
                    tail1 = tail1.next;
                }
            } else {
                if (head2 == null)
                    tail2 = head2 = traversal.next;
                else {
                    tail2.next = traversal.next;
                    tail2 = tail2.next;
                }
            }
            traversal = traversal.next;
        }
        if (tail2 != null) tail2.next = null;
        if (head1 != null) {
            tail1.next = head2;
            return head1;
        }
        return head2;
    }
}

// a more better solution
public class Solution2 {
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0);
        ListNode bigHead = new ListNode(0);
        ListNode smallTail = smallHead, bigTail = bigHead;
        while (head != null) {
            if (head.val < x) {
                smallTail.next = head;
                smallTail = smallTail.next;
            } else {
                bigTail.next = head;
                bigTail = bigTail.next;
            }
            head = head.next;
        }
        bigTail.next = null;
        smallTail.next = bigHead.next;
        return smallHead.next;
    }
}
