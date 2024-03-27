#include <vector>
#include <algorithm>

class Solution {
public:
    int rob(std::vector<int>& nums) {
        int n = nums.size();

        if (n == 1)
            return nums[0];
        else if (n == 2)
            return std::max(nums[0], nums[1]);

        int max1 = robHelper(nums, 0, n - 2);
        int max2 = robHelper(nums, 1, n - 1);

        return std::max(max1, max2);
    }

private:
    int robHelper(const std::vector<int>& nums, int st, int en) {
        int p1 = 0, p2 = 0, cur = 0;

        for (int i = st; i <= en; ++i) {
            cur = std::max(p1, p2 + nums[i]);
            p2 = p1;
            p1 = cur;
        }

        return cur;
    }
};