class Solution:
    def dominantIndex(self, nums: List[int]) -> int:
        lst=[i for i in nums]
        lst.sort()
        if (lst[-1] >= 2 * lst[-2]):
            
            return nums.index(max(nums))
        else:
            return -1