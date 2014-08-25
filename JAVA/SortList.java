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
// O(n) space, O(nlogn) time
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        ListNode[] nodes = new ListNode[count];
        temp = head;
        while (count > 0) {
            nodes[--count] = temp;
            temp = temp.next;
        }
        heapSort(nodes);
        for (int i = 0; i < nodes.length - 1; i++)
            nodes[i].next = nodes[i + 1];
        nodes[nodes.length - 1].next = null;
        return nodes[0];
    }
    
    private void heapSort(ListNode[] arr) {
        for (int i = arr.length / 2; i >= 0; i--)
            percDown(arr, i, arr.length);
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            percDown(arr, 0, i);
        }
    }
    
    private void percDown(ListNode[] arr, int i, int n) {
        int child;
        ListNode temp;
        for (temp = arr[i]; 2 * i + 1 < n; i = child) {
            child = 2 * i + 1;
            if (child != n - 1 && arr[child].val < arr[child + 1].val)
                child++;
            if (temp.val < arr[child].val)
                arr[i] = arr[child];
            else break;
        }
        arr[i] = temp;
    }
    
    private void swap(ListNode[] arr, int pos1, int pos2) {
        ListNode temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }
}

// recursive merge sort
public class Solution2 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode left = head, right = head.next;
        while (right != null && right.next != null) {
            left = left.next;
            right = right.next.next;
        }
        right = left.next;
        left.next = null;
        left = head;
        left = sortList(left);
        right = sortList(right);
        ListNode ret = mergeList(left, right);
        return ret;
    }
    
    private ListNode mergeList(ListNode left, ListNode right) {
        ListNode fakeHead = new ListNode(0), temp = fakeHead;
        while (left != null && right != null) {
            if (left.val < right.val) {
                if (fakeHead.next == null)
                    fakeHead.next = left;
                else 
                    temp.next = left;
                temp = temp.next;
                left = left.next;
            } else {
                if (fakeHead.next == null)
                    fakeHead.next = right;
                else 
                    temp.next = right;
                temp = temp.next;
                right = right.next;
            }
        }
        if (left == null)
            temp.next = right;
        else if (right == null)
            temp.next = left;
        return fakeHead.next;
    }
}