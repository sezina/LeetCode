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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Integer[] prev = new Integer[1];
        return validHelper(root, prev);
    }
    
    private boolean validHelper(TreeNode root, Integer[] prev) {
        if (root == null) return true;
        boolean leftbst = validHelper(root.left, prev);
        if (!leftbst) return false;
        if (prev[0] != null && root.val <= prev[0])
            return false;
        prev[0] = root.val;
        boolean rightbst = validHelper(root.right, prev);
        return leftbst && rightbst;
    }
}