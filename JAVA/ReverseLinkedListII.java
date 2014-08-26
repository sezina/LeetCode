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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode temp, preM = fakeHead, tempTail;
        int count = 1;
        while (count < m) {
            preM = preM.next;
            count++;
        }
        tempTail = preM.next;
        while (count < n) {
            temp = preM.next;
            preM.next = tempTail.next;
            tempTail.next = tempTail.next.next;
            preM.next.next = temp;
            count++;
        }
        return fakeHead.next;
    }
}