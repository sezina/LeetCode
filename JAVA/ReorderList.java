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