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
            boolean leftIsSame = isSameTree(p.left, q.left);
            boolean rightIsSame = isSameTree(p.right, q.right);
            isSame = leftIsSame & rightIsSame;
        }
        
        return isSame;
    }
}

// neat code
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q) return true;
        else if (q != null && p != null && q.val == p.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }
}
