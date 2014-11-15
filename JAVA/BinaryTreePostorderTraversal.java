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

// using only one stack;
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        do {
            while (root != null) {
                if (root.right != null) stack.push(root.right);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right != null && !stack.isEmpty() && root.right.val == stack.peek().val) {
                stack.pop();
                stack.push(root);
                root = root.right;
            } else {
                res.add(root.val);
                root = null;
            }
        } while (!stack.isEmpty());
        return res;
    }
}

// using two stack
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            root = stack1.pop();
            stack2.push(root);
            if (root.left != null) stack1.push(root.left);
            if (root.right != null) stack1.push(root.right);
        }
        while (!stack2.isEmpty()) 
            res.add(stack2.pop().val);
        return res;
    }
}