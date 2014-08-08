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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode traversal = head;
        ListNode nextNode = traversal.next;
        while (nextNode != null) {
            if (traversal.val == nextNode.val)
                traversal.next = nextNode.next;
            else 
                traversal = traversal.next;
            nextNode = nextNode.next;
        }
        return head;
    }
}


public class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head != null) {
            ListNode traversal = head;
            while (traversal.next != null) {
                if (traversal.val == traversal.next.val)
                    traversal.next = traversal.next.next;
                else 
                    traversal = traversal.next;
            }
        }
        return head;
    }
}