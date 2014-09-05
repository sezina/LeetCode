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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++)
            inMap.put(inorder[i], i);
        return buildHelper(postorder, inMap, postorder.length - 1, 0, postorder.length - 1);
    }
    
    private TreeNode buildHelper(int[] postorder, Map<Integer, Integer> inMap, int rootI, int low, int high) {
        if (rootI < 0 || low > high) return null;
        if (low == high) return new TreeNode(postorder[rootI]);
        TreeNode root = new TreeNode(postorder[rootI]);
        int inI = inMap.get(root.val);
        root.left = buildHelper(postorder, inMap, rootI - high + inI - 1 , low, inI - 1);
        root.right = buildHelper(postorder, inMap, rootI - 1, inI + 1, high);
        return root;
    }
}