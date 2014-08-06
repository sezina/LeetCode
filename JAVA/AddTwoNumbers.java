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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        
        ListNode resultNode = l1, traversal = l1;
        int carry = 0, temp = 0;
        while (traversal.next != null && l2.next != null) {
            temp = traversal.val + l2.val + carry;
            traversal.val = temp % 10;
            carry = temp / 10;
            l2 = l2.next;
            traversal = traversal.next;
        }
        
        temp = traversal.val + l2.val + carry;
        traversal.val = temp % 10;
        carry = temp / 10;
        if (traversal.next == null) {
            traversal.next = l2.next;
        }
        while (traversal.next != null) {
            traversal = traversal.next;
            temp = traversal.val + carry;
            traversal.val = temp % 10;
            carry = temp / 10;
        }
        
        if (carry == 1) {
            traversal.next = new ListNode(1);
        }
        return resultNode;
    }
}
