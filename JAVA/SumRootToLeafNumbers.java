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
    public int sumNumbers(TreeNode root) {
        return sumHelper(root, 0);
    }
    
    public int sumHelper(TreeNode root, int preSum) {
        if (root == null) return 0;
        
        int nodeSum = preSum * 10 + root.val;
        if (root.left == null && root.right == null)
            return nodeSum;
        
        return sumHelper(root.left, nodeSum) + sumHelper(root.right, nodeSum);
    }
}