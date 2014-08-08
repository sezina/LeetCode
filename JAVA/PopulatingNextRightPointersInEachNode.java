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
                TreeLinkNode traversal = null;
                while (i < nodes.size()) {
                    if (nodes.get(i).left != null) {
                        if (traversal == null) {
                            traversal = nodes.get(i).left;
                        } else {
                            traversal.next = nodes.get(i).left;
                            traversal = traversal.next;
                        }
                        temp.add(nodes.get(i).left);
                    }
                    if (nodes.get(i).right != null) {
                        if (traversal == null) {
                            traversal = nodes.get(i).right;
                        } else {
                            traversal.next = nodes.get(i).right;
                            traversal = traversal.next;
                        }
                        temp.add(nodes.get(i).right);
                    }
                    i++;
                }
                nodes.addAll(temp);
                temp.clear();
            }
        }
    }
}
