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