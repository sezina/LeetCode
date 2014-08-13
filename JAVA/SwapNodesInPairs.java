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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode back = head, front = head.next, hold = null;
        head = head.next;
        while (back != null && front != null) {
            back.next = front.next;
            front.next = back;
            if (hold == null)
                hold = back;
            else {
                hold.next = front;
                hold = back;
            }
            back = back.next;
            if (back != null)
                front = back.next;
        }
        return head;
    }
}