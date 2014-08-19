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
    public boolean isBalanced(TreeNode root) {
        if (depth(root) == -1)
            return false;
        return true;
    }
    
    public static int depth(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = depth(root.left);
        if (leftDepth == -1)
            return -1;
        int rightDepth = depth(root.right);
        if (rightDepth == -1)
            return -1;
        
        if (Math.abs(leftDepth - rightDepth) < 2)
            return Math.max(leftDepth, rightDepth) + 1;
        return -1;
    }
}