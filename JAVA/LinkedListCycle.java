/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        else {
            ListNode back = head.next;
            ListNode forward = head.next.next;
            while (back != null && forward != null) {
                if (back.val == forward.val)
                    return true;
                back = back.next;
                if (forward.next != null)
                    forward = forward.next.next;
                else
                    forward = null;
            }
            return false;
        }
    }
}