class Solution {
public:
    int dfs(int i, int p, vector<vector<array<int, 3>>> &al) {
        int res = 0;
        for (auto &[j, weight, memo] : al[i]) {
            if (j == p)
                continue;
            if (memo == -1)
                memo = weight + dfs(j, i, al);
            res += memo;
        }
        return res;
    }
    vector<int> minEdgeReversals(int n, vector<vector<int>>& edges) {
        vector<vector<array<int, 3>>> al(n);
        vector<int> res(n);
        for (const auto &e : edges) {
            al[e[0]].push_back({e[1], 0, -1});
            al[e[1]].push_back({e[0], 1, -1});
        }
        for (int i = 0; i < n; ++i)
            res[i] = dfs(i, i, al);
        return res;
    }
};
