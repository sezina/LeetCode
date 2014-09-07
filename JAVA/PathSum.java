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
    private int sum;
    public boolean hasPathSum(TreeNode root, int sum) {
        this.sum = sum;
        return sumHelper(root, 0);
    }
    
    private boolean sumHelper(TreeNode root, int curSum) {
        if (root == null) return false;
        curSum += root.val;
        if (root.left == null && root.right == null)
            return curSum == sum;
        return sumHelper(root.left, curSum) || sumHelper(root.right, curSum);
    }
}