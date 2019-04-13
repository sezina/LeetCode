/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * # 173
 * https://leetcode.com/problems/binary-search-tree-iterator/
 */
import java.util.Stack;

class BSTIterator {

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();

        TreeNode temp = root;
        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
    }

    public int next() {
        TreeNode peak = stack.pop();
        TreeNode temp = peak.right;
        if (temp != null) {
            stack.push(temp);
            temp = temp.left;
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
        }

        return peak.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
