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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        Map<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++)
            inorderMap.put(inorder[i], i);
        return buildHelper(preorder, inorder, inorderMap, 0, 0, preorder.length - 1);
    }
    
    private TreeNode buildHelper(int[] preorder, int[] inorder,
                                Map<Integer, Integer> inorderMap, int rootI, int low, int high) {
        if (low > high || rootI >= preorder.length) return null;
        if (low == high) return new TreeNode(preorder[rootI]);
        TreeNode root = new TreeNode(preorder[rootI]);
        int inI = inorderMap.get(root.val);
        root.left = buildHelper(preorder, inorder, inorderMap, rootI + 1, low, inI - 1);
        root.right = buildHelper(preorder, inorder, inorderMap, inI - low + rootI + 1, inI + 1, high);
        return root;
    }
}
