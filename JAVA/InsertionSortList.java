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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fakeHead = new ListNode(0), insertPos = fakeHead, minPointer = head, temp = head, preMin = fakeHead;
        fakeHead.next = head;
        while (minPointer.next != null) {
            while (temp != null && temp.next != null) {
                if (temp.next.val < minPointer.val) {
                    preMin = temp;
                    minPointer = preMin.next;
                }
                temp = temp.next;
            }
            preMin.next = minPointer.next;
            minPointer.next = insertPos.next;
            insertPos.next = minPointer;
            insertPos = insertPos.next;
            preMin = insertPos;
            minPointer = preMin.next;
            temp = minPointer;
        }
        return fakeHead.next;
    }
}