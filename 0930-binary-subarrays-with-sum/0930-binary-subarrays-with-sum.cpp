class Solution {
public:
    // time/space: O(n)/O(1)
    int numSubarraysWithSum(vector<int>& nums, int goal) {
        int result = 0;

        // sliding window
        for (int l = 0, r = 0, sum = 0, tail = 0; r < nums.size(); r++) {
            sum += nums[r];
            
            // reset the tail if the sum is increased
            if (nums[r] == 1) tail = 0;

            // shrink the window if `sum >= goal`
            while ((l <= r) && (sum >= goal)) {
                // record the length of the tail zero(s)
                if (sum == goal) tail++;
                sum -= nums[l++];
            }

            // update the result
            result += tail;
        }
        return result;
    }
};