class Solution {
public:
    
int findChampion(vector<vector<int>>& grid) {
    int ans = -1, count = 0;
    vector<int> indegree(grid.size(), 0);
    for(int i = 0; i < grid.size(); ++i){
        for(int j = 0; j < grid.size(); ++j){
            if(i == j) continue;
            if(grid[i][j]) indegree[j]++;
            else indegree[i]++;
        }
    }
    for(int i = 0; i < grid.size(); ++i) {
        if(indegree[i] == 0) {count++; ans = i; }
    }
    return count > 1?-1:ans;
}
};