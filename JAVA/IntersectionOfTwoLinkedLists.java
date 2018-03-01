/**
 * Problem 160
 *
 * @author sezina
 * @since 3/1/18
 */
public class IntersectionOfTwoLinkedLists {

    /**
     * Definition for singly-linked list.*/
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null)
                return null;

            int lenA = 0, lenB = 0;
            ListNode nodeA = headA, nodeB = headB;
            while (nodeA != null) {
                lenA++;
                nodeA = nodeA.next;
            }
            while (nodeB != null) {
                lenB++;
                nodeB = nodeB.next;
            }

            if (lenA > lenB) {
                nodeA = headA;
                headA = headB;
                headB = nodeA;
            }
            nodeA = headA;
            nodeB = headB;
            int gap = Math.abs(lenA - lenB);
            while (gap-- > 0) {
                nodeB = nodeB.next;
            }

            while (nodeA != null && nodeB != null) {
                if (nodeA.val == nodeB.val) return nodeA;
                nodeA = nodeA.next;
                nodeB = nodeB.next;
            }
            return null;
        }
    }
}
