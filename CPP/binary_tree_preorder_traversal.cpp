class Solution {
public:
    vector<int> preorderTraversal(TreeNode *root) {
        stack<TreeNode*> tn_stack;
        if (root != NULL) {
            tn_stack.push(root);
        }
        
        vector<int> result;
        while (!tn_stack.empty()) {
            root = tn_stack.top();
            tn_stack.pop();
            result.push_back(root->val);
            if (root->right != NULL) {
                tn_stack.push(root->right);
            }
            if (root->left != NULL) {
                tn_stack.push(root->left);
            }
            
        }
        return result;
    }
};
