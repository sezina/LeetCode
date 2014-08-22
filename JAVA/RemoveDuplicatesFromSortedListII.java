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
        ListNode temp, front;
        while (head != null && head.next != null && head.val == head.next.val) {
            head = head.next;
            if (head.next == null || (head.next != null && head.next.val != head.val))
                head = head.next;
        }
        if (head == null || head.next == null) return head;
        
        front = head;
        while (front.next != null) {
            temp = front.next;
            if (temp.next == null) break;
            while (temp != null && temp.next != null) {
                if (temp.next.val == temp.val) {
                    int value = temp.val;
                    front.next = temp.next;
                    temp = temp.next;
                    while (temp != null && temp.val == value) {
                        front.next = temp.next;
                        temp = temp.next;
                    }
                } else {
                    front = temp;
                    temp = temp.next;
                }
            }
        }
        return head;
    }
}