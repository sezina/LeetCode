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
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.isEmpty()) return null;
        if (lists.size() == 1) return lists.get(0);
        List<Integer> vals = new ArrayList<Integer>();
        Map<Integer, ListNode> map = new HashMap<Integer, ListNode>();
        for (ListNode node : lists) {
            while (node != null) {
                ListNode temp = node;
                node = node.next;
                if (map.containsKey(temp.val))
                    temp.next = map.get(temp.val);
                else {
                    temp.next = null;
                    vals.add(temp.val);
                }
                map.put(temp.val, temp);
            }
        }
        if (vals.isEmpty()) return null;
        Collections.sort(vals);
        ListNode temp = map.get(vals.get(0));
        for (int i = 1; i < vals.size(); i++) {
            while (temp.next != null)
                temp = temp.next;
            temp.next = map.get(vals.get(i));
        }
        
        return map.get(vals.get(0));
    }
}

// priority queue
public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.isEmpty()) return null;
        if (lists.size() == 1) return lists.get(0);
        ListNode fakeHead = new ListNode(0);
        ListNode temp = fakeHead;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
            public int compare(ListNode n1, ListNode n2) {
                if (n1.val < n2.val) return -1;
                else if (n1.val > n2.val) return 1;
                return 0;
            }
        });
        for (int i = 0; i < lists.size(); i++)
            if (lists.get(i) != null) queue.add(lists.get(i));
        
        while (!queue.isEmpty()) {
            temp.next = queue.poll();
            temp = temp.next;
            if (temp.next != null) queue.add(temp.next);
        }
        return fakeHead.next;
    }
}
