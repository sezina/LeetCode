/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root != null) {
            List<TreeLinkNode> nodes = new ArrayList<TreeLinkNode>(Arrays.asList(root));
            List<TreeLinkNode> temp = new ArrayList<TreeLinkNode>();
            int i = 0;
            while (i < nodes.size()) {
                while (i < nodes.size()) {
                    if (i != nodes.size() - 1)
                        nodes.get(i).next = nodes.get(i + 1);
                    if (nodes.get(i).left != null)
                        temp.add(nodes.get(i).left);
                    if (nodes.get(i).right != null)
                        temp.add(nodes.get(i).right);
                    i++;
                }
                nodes.addAll(temp);
                temp.clear();
            }
        }
    }
}
