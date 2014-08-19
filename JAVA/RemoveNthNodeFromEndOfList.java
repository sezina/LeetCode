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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0)
            return head;
        ListNode delPointer = head, detector = head, temp;
        for (int i = 0; i < n; i++)
            detector = detector.next;
        if (detector == null) {
            head = head.next;
            return head;
        }
        detector = detector.next;
        while (detector != null) {
            detector = detector.next;
            delPointer = delPointer.next;
        }
        temp = delPointer.next;
        delPointer.next = temp.next;
        temp.next = null;
        return head;
    }
}