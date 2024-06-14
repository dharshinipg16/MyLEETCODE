class Solution:
    def minIncrementForUnique(self, nums: List[int]) -> int:
        nums.sort()  # Step 1: Sort the array
        min_increment = 0
        for i in range(1, len(nums)):  # Step 2: Traverse and increment
            if nums[i] <= nums[i - 1]:
                increment = nums[i - 1] - nums[i] + 1
                nums[i] += increment
                min_increment += increment
        return min_increment
