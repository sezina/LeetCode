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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root != null) {
            int i = 0;
            List<List<TreeNode>> levelNodes = new ArrayList<List<TreeNode>>();
            List<TreeNode> level = new LinkedList<TreeNode>();
            level.add(root);
            levelNodes.add(level);
            while(i < levelNodes.size()) {
                List<TreeNode> nextLevel = new LinkedList<TreeNode>();
                List<Integer> levelRst = new LinkedList<Integer>();
                level = levelNodes.get(i);
                for (TreeNode node : level) {
                    levelRst.add(node.val);
                    if (node.left != null)
                        nextLevel.add(node.left);
                    if (node.right != null)
                        nextLevel.add(node.right);
                }
                if (!nextLevel.isEmpty()) {
                    levelNodes.add(nextLevel);
                }
                
                result.add(levelRst);
                i++;
            }
        }
        return result;
    }
}