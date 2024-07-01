class Solution {
public:
    int find(vector<vector<int>>& nums,int a,int b,int x,int y,int k){
        for(int i = a; i<=x;++i){
            for(int j = b; j<=y;++j){
                if(nums[i][j]==k || nums[i][j]==0) continue;
                else return 0;
            }
        }
        for(int i = a; i<=x;++i){
            for(int j = b; j<=y;++j) nums[i][j] = 0;
        }
        return 1;
    }
    bool isPrintable(vector<vector<int>>& nums) {
        unordered_map<int,pair<int,int>> max_;
        unordered_map<int,pair<int,int>> min_;
        unordered_set<int> mp;
        for(int i = 0; i<nums.size();++i){
            for(int j = 0; j<nums[0].size();++j){
                if(mp.find(nums[i][j])==mp.end()){
                    max_[nums[i][j]] = {i,j};
                    min_[nums[i][j]] = {i,j};
                }
                else{
                    max_[nums[i][j]].first = max(max_[nums[i][j]].first,i);
                    max_[nums[i][j]].second = max(max_[nums[i][j]].second,j);
                    min_[nums[i][j]].first = min(min_[nums[i][j]].first,i);
                    min_[nums[i][j]].second = min(min_[nums[i][j]].second,j);
                }
                mp.insert(nums[i][j]);
            }
        }
        while(mp.size()){
            bool st = 0;
            for(auto&it:mp){
                bool k = 
                    find(nums,min_[it].first,min_[it].second,max_[it].first,max_[it].second,it);
                if(k==1){
                    st = 1; mp.erase(it);
                    break;
                }
            }
            if(st == 0) return 0;
        }
        return 1;
    }
};