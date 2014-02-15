class Solution {
public:
    vector<int> inorderTraversal(TreeNode *root) {
        vector<int> result;
        stack<TreeNode*> tn_stack;
        while (root != NULL || !tn_stack.empty()) {
            while (root != NULL) {
                tn_stack.push(root);
                root = root->left;
            }
            if (!tn_stack.empty()) {
                root = tn_stack.top();
                tn_stack.pop();
                result.push_back(root->val);
                root = root->right;
            }
          
        }
        return result;
    }
};
