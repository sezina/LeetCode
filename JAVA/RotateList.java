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
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) return head;
        ListNode tail = head;
        int count = 1;
        while (tail.next != null) {
            count++;
            tail = tail.next;
        }
        tail.next = head;
        count = count - n % count;
        while(count-- > 0) {
            head = head.next;
            tail = tail.next;
        }
        tail.next = null;
        return head;
    }
}