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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            while(!stack.isEmpty()) {
                root = stack.pop();
                result.add(root.val);
                if (root.right != null)
                    stack.push(root.right);
                if (root.left != null)
                    stack.push(root.left);
            }
        }
        
        return result;
    }
}