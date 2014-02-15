class Solution {
public:
    vector<int> postorderTraversal(TreeNode *root) {
        pair<TreeNode *, char> node_with_flag;
        stack<pair<TreeNode *, char>> s;
        vector<int> result;
        TreeNode *node = root;
        if (root == NULL) {
            return result;
        }
        do {
            while (node != NULL) {
                node_with_flag.first = node;
                node_with_flag.second = 'L';
                s.push(node_with_flag);
                node = node->left;
            }
            bool is_continue = true;
            while (is_continue && !s.empty()) {
                node_with_flag = s.top();
                node = node_with_flag.first;
                s.pop();
                if (node_with_flag.second == 'L') {
                    node_with_flag.second = 'R';
                    s.push(node_with_flag);
                    is_continue = false;
                    node = node->right;
                } else {
                    result.push_back(node->val);
                }
            }
        } while (!s.empty());
        return result;

    }
};