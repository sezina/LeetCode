/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// O(n) space and O(n) time
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode traversal = head;
        List<ListNode> arr = new ArrayList<ListNode>();
        while (traversal != null) {
            arr.add(traversal);
            traversal = traversal.next;
        }
        int n = arr.size();
        for (int i = 0; i < n / 2; i++) {
            arr.get(i).next = arr.get(n - i - 1);
            arr.get(n - i - 1).next = arr.get(i + 1);
        }
        arr.get(n / 2).next = null;
    }
}

// O(1) space solution
public class Solution2 {
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode slow = head, fast = head.next, temp;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow.next != null)
            fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        while (slow != null && fast != null) {
            temp = slow.next;
            slow.next = fast;
            slow = temp;
            temp = fast.next;
            fast.next = slow;
            fast = temp;
        }
    }
    
    private ListNode reverse(ListNode head) {
        ListNode tail = head, traversal = head.next, temp = head;
        while (traversal != null) {
            head = traversal;
            tail.next = traversal.next;
            head.next = temp;
            temp = head;
            traversal = tail.next;
        }
        return head;
    }
}