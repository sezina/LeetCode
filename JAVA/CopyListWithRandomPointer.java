/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        int nodeCount = 0;
        RandomListNode traversal = head;
        while  (traversal != null) {
            nodeCount++;
            traversal = traversal.next;
        }
        Map<RandomListNode, Integer> indexMap = new HashMap<RandomListNode, Integer>();
        RandomListNode[] copys = new RandomListNode[nodeCount];
        traversal = head;
        for (int i = 0; i < nodeCount; i++) {
            indexMap.put(traversal, i);
            copys[i] = new RandomListNode(traversal.label);
            if (i != 0)
                copys[i - 1].next = copys[i];
            traversal = traversal.next;
        }
        traversal = head;
        for (int i = 0; i < nodeCount; i++) {
            if (traversal.random != null)
                copys[i].random = copys[indexMap.get(traversal.random)];
            traversal = traversal.next;
        }
        
        return copys[0];
    }
}

public class Solution2 {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> nodeMap = new HashMap<RandomListNode, RandomListNode>();
        return copyHelper(head, nodeMap);
    }
    
    public RandomListNode copyHelper(RandomListNode head, Map<RandomListNode, RandomListNode> nodeMap) {
        if (head == null) return null;
        if (nodeMap.containsKey(head)) return nodeMap.get(head);
        RandomListNode result = new RandomListNode(head.label);
        nodeMap.put(head, result);
        result.next = copyHelper(head.next, nodeMap);
        result.random = copyHelper(head.random, nodeMap);
        return result;
    }
}