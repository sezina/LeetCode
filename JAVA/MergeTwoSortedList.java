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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        
        ListNode head, temp;
        if (l2.val < l1.val) {
            temp = l1;
            l1 = l2;
            l2 = temp;
        }
        head = l1;
        while (l1.next != null && l2 != null) {
            if (l1.next.val <= l2.val)
                l1 = l1.next;
            else {
                temp = l2.next;
                l2.next = l1.next;
                l1.next = l2;
                l2 = temp;
                l1 = l1.next;
            }
        }
        if (l1.next == null)
            l1.next = l2;
        return head;
    }
}