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
    List<List<Integer>> res;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        target = sum;
        sumHelper(root, new Stack<Integer>(), 0);
        return res;
    }
    
    private void sumHelper(TreeNode root, Stack<Integer> stack , int curSum) {
        stack.add(root.val);
        if (root.left == null && root.right == null) {
            if (curSum + root.val == target)
                res.add(new ArrayList<Integer>(stack));
            return;
        }
        curSum += root.val;
        if (root.left != null) {
            sumHelper(root.left, stack, curSum);
            stack.pop();
        }
        if (root.right != null) {
            sumHelper(root.right, stack, curSum);
            stack.pop();
        }
    }
}