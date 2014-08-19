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
// not in space
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<ListNode>();
        while(head != null) {
            if (nodeSet.contains(head))
                return head;
            else {
                nodeSet.add(head);
                head = head.next;
            }
        }
        return head;
    }
}

public class Solution2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        ListNode anchor = head, fast = head.next, slow = head;
        while(slow != null && fast != null) {
            if (slow == fast) {
                while (true) {
                    do {
                        if (fast == anchor)
                            return anchor;
                        fast = fast.next;
                    } while (fast != slow);
                    anchor = anchor.next;
                }
            } else {
                slow = slow.next;
                if (fast.next != null)
                    fast = fast.next.next;
                else
                    fast = null;
            }
        }
        return null;
    }
}
