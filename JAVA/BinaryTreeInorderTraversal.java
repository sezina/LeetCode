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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        Stack<TreeNode> nodes = new Stack<TreeNode>();
        while (root != null || !nodes.isEmpty()) {
            while(root != null) {
                nodes.push(root);
                root = root.left;
            }
            root = nodes.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
}
