class Solution {
public:
    vector<vector<int> > zigzagLevelOrder(TreeNode *root) {
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
        for (int i = 0; i < result.size(); i++) {
            if (i % 2 == 1) {
                reverse(result[i].begin(), result[i].end());
            }
        }
        
        return result;
    }
};