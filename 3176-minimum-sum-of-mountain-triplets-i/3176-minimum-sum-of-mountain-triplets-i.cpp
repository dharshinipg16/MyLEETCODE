class Solution {
public:
    int minimumSum(vector<int>& nums) {
        int sz = nums.size();
        vector<int> minLeft(sz, 0), minRight(sz, 0);
        for(int indx = 0; indx < sz; indx++){
            minLeft[indx] = min((indx - 1 > -1) ? minLeft[indx-1] : INT_MAX, nums[indx]);
        }
        for(int indx = sz - 1; indx >= 0; indx--){
            minRight[indx] = min((indx + 1 < sz) ? minRight[indx+1] : INT_MAX, nums[indx]);
        }
        int minSum = INT_MAX;
        for(int indx = 1; indx < sz-1; indx++){
            if(minLeft[indx - 1] >= nums[indx] || minRight[indx + 1] >= nums[indx])continue;
            int leftValue = minLeft[indx - 1];
            int rightValue = minRight[indx + 1];
            minSum = min(minSum, nums[indx] + rightValue + leftValue);
        }
        return minSum == INT_MAX ? - 1 : minSum;
    }
};