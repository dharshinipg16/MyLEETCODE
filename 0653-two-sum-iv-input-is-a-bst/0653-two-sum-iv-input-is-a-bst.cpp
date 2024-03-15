class Solution {
public:
    void createVector(TreeNode* root, vector<int> &vec) {
        if (!root) return;
        createVector(root->left, vec);
        vec.push_back(root->val);
        createVector(root->right, vec);
    }

    bool findTarget(TreeNode* root, int k) {
        vector<int> vec;
        createVector(root, vec);
        bool ans = false;
        for (int i = 0; i < vec.size(); i++) {
            for (int j = i + 1; j < vec.size(); j++) {
                if (vec[i] + vec[j] == k) {
                    ans = true;
                    break;
                }
            }
            if (ans) break;
        }
        return ans;
    }
};
