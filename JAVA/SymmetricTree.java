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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) 
            return true;
        Stack<TreeNode> leftStack = new Stack<TreeNode>();
        Stack<TreeNode> rightStack = new Stack<TreeNode>();
        leftStack.add(root.left);
        rightStack.add(root.right);
        while (!leftStack.isEmpty() && !rightStack.isEmpty()) {
            TreeNode a = leftStack.pop();
            TreeNode b = rightStack.pop();
            if (a == null && b == null) continue;
            if (a == null || b == null) return false;
            if (a.val != b.val) return false;
            leftStack.push(a.left);
            leftStack.push(a.right);
            rightStack.push(b.right);
            rightStack.push(b.left);
        }
        return true;
    }
}

// recursive
public class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) 
            return true;
        return symmetricTest(root.left, root.right);
    }
    
    public static boolean symmetricTest(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) return true;
        if (leftNode == null || rightNode == null) return false;
        if (leftNode.val !=  rightNode.val) return false;
        return symmetricTest(leftNode.left, rightNode.right) && symmetricTest(leftNode.right, rightNode.left);
    }
}