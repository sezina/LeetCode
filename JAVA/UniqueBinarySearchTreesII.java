/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
// recursive solution
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return treeHelper(1, n);
    }
    
    private List<TreeNode> treeHelper(int start, int end) {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        if (start > end) {
            ans.add(null);
            return ans;
        }
        if (start == end) {
            ans.add(new TreeNode(start));
            return ans;
        }
        
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = treeHelper(start, i - 1);
            List<TreeNode> right = treeHelper(i + 1, end);
            
            for (TreeNode ln : left) {
                for (TreeNode rn : right) {
                    TreeNode node = new TreeNode(i);
                    node.left = ln;
                    node.right = rn;
                    ans.add(node);
                }
            }
        }
        return ans;
    }
}