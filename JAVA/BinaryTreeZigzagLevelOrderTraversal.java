/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// recursive
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        zigzagHelper(root, res, 0);
        return res;
    }
    
    private void zigzagHelper(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) return;
        if (res.size() == level) res.add(new ArrayList<Integer>());
        if (level % 2 == 0) res.get(level).add(root.val);
        else res.get(level).add(0, root.val);
        zigzagHelper(root.left, res, level + 1);
        zigzagHelper(root.right, res, level + 1);
    }
}

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null)
            return result;
        
        List<List<TreeNode>> levelNodes = new ArrayList<List<TreeNode>>();
        List<TreeNode> level = new ArrayList<TreeNode>();
        level.add(root);
        levelNodes.add(level);
        boolean zig = true;
        int i = 0;
        while (i < levelNodes.size()) {
            List<Integer> levelRst = new LinkedList<Integer>();
            level = new ArrayList<TreeNode>();
            
            List<TreeNode> traversal = levelNodes.get(i);
            for (TreeNode node : traversal) {
                levelRst.add(node.val);
            }
            Collections.reverse(traversal);
            for (TreeNode node : traversal) {
                
                if (zig) {
                    if (node.right != null)
                        level.add(node.right);
                    if (node.left != null)
                        level.add(node.left);
                } else {
                    if (node.left != null)
                        level.add(node.left);
                    if (node.right != null)
                        level.add(node.right);
                }
            }
            result.add(levelRst);
            if (!level.isEmpty())
                levelNodes.add(level);
            zig = zig ? false : true;
            i++;
        }
        return result;
    }
}