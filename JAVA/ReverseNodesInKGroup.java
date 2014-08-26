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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) return head;
        ListNode fakeHead = new ListNode(0);
        ListNode preHead = fakeHead, tail = head, detector = head.next.next, temp;
        fakeHead.next = head;
        int count = 2;
        while (true) {
            while (detector != null && count < k) {
                count++;
                detector = detector.next;
            }
            if (count < k) break;
            while (--count > 0) {
                temp = preHead.next;
                preHead.next = tail.next;
                tail.next = preHead.next.next;
                preHead.next.next = temp;
            }
            preHead = tail;
            tail = tail.next;
            count = 0;
        }
        return fakeHead.next;
    }
}