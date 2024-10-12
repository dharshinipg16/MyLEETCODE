class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        nums3=nums1+nums2
        nums3.sort()
        if (len(nums3)%2!=0):
            return(nums3[(len(nums3)-1)//2])
        else:
            a=len(nums3)//2
            b=a-1
            median=(nums3[a]+nums3[b])/2
            return median