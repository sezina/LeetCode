// naive solution
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        if (node.neighbors.isEmpty()) return new UndirectedGraphNode(node.label);
        Set<Integer> visited = new HashSet<Integer>();
        Map<Integer, UndirectedGraphNode> nodeMap = new HashMap<Integer, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new ArrayDeque<UndirectedGraphNode>();
        queue.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode node1 = queue.poll();
            if (visited.contains(node1.label)) continue;
            if (!nodeMap.containsKey(node1.label))
                nodeMap.put(node1.label, new UndirectedGraphNode(node1.label));
            visited.add(node1.label);
            for (UndirectedGraphNode neighbor : node1.neighbors) {
                if (!visited.contains(neighbor.label))
                    queue.add(neighbor);
                if (!nodeMap.containsKey(neighbor.label))
                    nodeMap.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                nodeMap.get(node1.label).neighbors.add(nodeMap.get(neighbor.label));
            }
        }
        return nodeMap.get(node.label);
    }
}