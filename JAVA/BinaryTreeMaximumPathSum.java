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
    public int maxPathSum(TreeNode root) {
        int[] max = {Integer.MIN_VALUE};
        sumHelper(root, max);
        return max[0];
    }
    
    private int sumHelper(TreeNode root, int[] max) {
        if (root == null) return 0;
        int leftMax = sumHelper(root.left, max);
        int rightMax = sumHelper(root.right, max);
        int lorRoot = Math.max(leftMax, rightMax) + root.val;   // case: left-root, or right-root
        int arc = leftMax + root.val + rightMax;    // case: left-root-right
        int mergeMax = Math.max(root.val, lorRoot);
        
        max[0] = Math.max(max[0], Math.max(arc, mergeMax));
        
        return mergeMax;    // the case: left-root-right cannot go up
    }
}