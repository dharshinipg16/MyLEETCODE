from typing import List

class Solution:
    def findLengthOfLCIS(self, nums: List[int]) -> int:
        if not nums:
            return 0

        ans = 1
        count = 1
        for i in range(1, len(nums)):
            if nums[i] > nums[i - 1]:
                count += 1
                ans = max(ans, count)
            else:
                count = 1

        return ans