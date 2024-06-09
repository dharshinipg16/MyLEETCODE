from collections import defaultdict
from typing import List

class Solution:
    def subarraysDivByK(self, nums: List[int], k: int) -> int:
        count = 0
        prefix_sum_remainders = defaultdict(int)
        prefix_sum_remainders[0] = 1  # Initialize to 1 to handle the subarray starting at index 0.

        prefix_sum = 0

        for num in nums:
            prefix_sum = (prefix_sum + num) % k
            count += prefix_sum_remainders[prefix_sum]
            prefix_sum_remainders[prefix_sum] += 1

        return count
