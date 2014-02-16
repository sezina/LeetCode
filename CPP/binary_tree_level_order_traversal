class Solution {
public:
    vector<vector<int> > levelOrder(TreeNode *root) {
        vector<vector<int>> result;
        queue<TreeNode *> q;
        int curr_level_node_count = 0;
        int next_level_node_count = 0;
        if (root != NULL) {
            curr_level_node_count = 1;
            q.push(root);
        }
        while (!q.empty()) {
            next_level_node_count = 0;
            vector<int> curr_level_value;
            while (curr_level_node_count--) {
                root = q.front();
                q.pop();
                if (root->left) {
                    q.push(root->left);
                    next_level_node_count++;
                }
                if (root->right) {
                    q.push(root->right);
                    next_level_node_count++;
                }
                curr_level_value.push_back(root->val);
            }
            result.push_back(curr_level_value);
            curr_level_node_count = next_level_node_count;
        }
        return result;
    }
};