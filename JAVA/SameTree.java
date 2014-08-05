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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean isSame = false;
        if (p == null && q == null)
            isSame = true;
        else if ((p == null && q != null) || (p != null && q == null) || (p.val != q.val))
            isSame = false;
        else if (p.val == q.val) {
            isSame = true;
            boolean leftIsSame = isSameTree(p.left, q.left);
            boolean rightIsSame = isSameTree(p.right, q.right);
            isSame &= leftIsSame & rightIsSame;
        }
        
        return isSame;
    }
}