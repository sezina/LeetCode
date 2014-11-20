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
    public void flatten(TreeNode root) {
        root = flattenHelper(root);
    }
    
    private TreeNode flattenHelper(TreeNode root) {
        if (root == null) return root;
        TreeNode tempRight = root.right, cur = root;
        cur.right = flattenHelper(cur.left);
        while (cur.right != null)
            cur = cur.right;
        cur.right = flattenHelper(tempRight);
        root.left = null;
        return root;
    }
}

// in-place
public class Solution {
    public void flatten(TreeNode root) {
        TreeNode node = root, temp;
        while (node != null) {
            if (node.left != null) {
                temp = node.left;
                while (temp.right != null) temp = temp.right;
                temp.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            node = node.right;
        }
    }
}