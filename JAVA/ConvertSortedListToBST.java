/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode slow = head, fast = head.next.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode treeHead = new TreeNode(slow.next.val);
        treeHead.right = sortedListToBST(slow.next.next);
        slow.next.next = null;
        slow.next = null;
        treeHead.left = sortedListToBST(head);
        return treeHead;
    }
}

// bottom-up solution
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int size = 0;
        ListNode traverse = head;
        while (traverse != null) {
            traverse = traverse.next;
            size++;
        }
        return helper(new ListNode[]{head}, 0, size - 1);
    }
    
    private TreeNode helper(ListNode[] head, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2; // avoids overflow
        TreeNode left = helper(head, start, mid - 1);
        TreeNode parent = new TreeNode(head[0].val);
        parent.left = left;
        head[0] = head[0].next;
        parent.right = helper(head, mid + 1, end);
        return parent;
    }
}