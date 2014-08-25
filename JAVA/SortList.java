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