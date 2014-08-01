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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root != null) {
            List<List<TreeNode>> levelNodes = new ArrayList<List<TreeNode>>();
            List<TreeNode> level = new LinkedList<TreeNode>();
            level.add(root);
            levelNodes.add(level);
            int i = 0;
            while (i < levelNodes.size()) {
                level = levelNodes.get(i);
                List<Integer> levelRst = new LinkedList<Integer>();
                List<TreeNode> nextLevel = new LinkedList<TreeNode>();
                for (TreeNode node : level) {
                    levelRst.add(node.val);
                    if (node.left != null)
                        nextLevel.add(node.left);
                    if (node.right != null)
                        nextLevel.add(node.right);
                }
                if (!nextLevel.isEmpty())
                    levelNodes.add(nextLevel);
                result.add(0, levelRst);
                i++;
            }
        }
        return result;
    }
}