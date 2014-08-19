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
    private static final int IS_NOT_BALANCED = -1;
    public boolean isBalanced(TreeNode root) {
        return depth(root) != IS_NOT_BALANCED;
    }
    
    public static int depth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = depth(root.left);
        if (leftDepth == IS_NOT_BALANCED) return IS_NOT_BALANCED;
        int rightDepth = depth(root.right);
        if (rightDepth == IS_NOT_BALANCED) return IS_NOT_BALANCED;
        
        if (Math.abs(leftDepth - rightDepth) < 2)
            return Math.max(leftDepth, rightDepth) + 1;
        return IS_NOT_BALANCED;
    }
}