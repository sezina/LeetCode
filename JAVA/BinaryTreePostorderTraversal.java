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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        if (root != null) {
            Set<TreeNode> visitedSet = new HashSet<TreeNode>();
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            while(!stack.isEmpty()) {
                root = stack.peek();
                if ((root.right == null && root.left == null) ||
                    (visitedSet.contains(root.left) && root.right == null) ||
                    (root.left == null && visitedSet.contains(root.right)) ||
                    (visitedSet.contains(root.left) && visitedSet.contains(root.right))) {
                    result.add(root.val);
                    visitedSet.add(root);
                    stack.pop();
                    continue;
                }
                if (root.right != null && !visitedSet.contains(root.right))
                    stack.push(root.right);
                if (root.left != null && !visitedSet.contains(root.left))
                    stack.push(root.left);
            }
        }
        return result;
    }
}
