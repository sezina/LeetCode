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

// recursive solution O(nlogn) time and O(n) space
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        traverse(root, result, 0);
        return result;
    }
    
    private void traverse(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) return;
        
        List<Integer> ans = null;
        if (res.size() == level) {
            ans = new ArrayList<Integer>();
            res.add(ans);
        } else 
            ans = res.get(level);
        ans.add(root.val);
        traverse(root.left, res, level+1);
        traverse(root.right, res, level+1);
    }
}