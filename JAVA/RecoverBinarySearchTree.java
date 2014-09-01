/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// recursive solution
public class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode[] wrongNode = new TreeNode[2];
        int[] pre = new int[1];
        boolean[] findFirst = {false};
        recoverHelper(root, findFirst, wrongNode, pre);
        int temp = wrongNode[0].val;
        wrongNode[0].val = wrongNode[1].val;
        wrongNode[1].val = temp;
    }
    
    private void recoverHelper(TreeNode root, boolean[] findFirst, TreeNode[] wrongNode, int[] pre) {
        if (root == null) return;
        
        recoverHelper(root.left, findFirst, wrongNode, pre);
        if (!findFirst[0]) {
            if (wrongNode[0] != null && root.val < wrongNode[0].val) {
                findFirst[0] = true;
                wrongNode[1] = root;
                pre[0] = root.val;
            }
            else wrongNode[0] = root;
        } else {
            if (root.val < pre[0]) {
                wrongNode[1] = root;
                return;
            }
            pre[0] = root.val;
        }
        recoverHelper(root.right, findFirst, wrongNode, pre);
    }
}