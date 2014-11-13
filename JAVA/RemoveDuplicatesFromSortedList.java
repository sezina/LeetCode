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
        if (head != null) {
            ListNode traversal = head, temp;
            while (traversal.next != null) {
                if (traversal.val == traversal.next.val) {
                    temp = traversal.next;
                    traversal.next = traversal.next.next;
                    temp.next = null;
                } else traversal = traversal.next;
            }
        }
        return head;
    }
}