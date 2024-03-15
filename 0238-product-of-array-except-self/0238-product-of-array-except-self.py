class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        answer=[0 for i in range(len(nums))]
        if 0 in nums and nums.count(0)==1:
            mul=1
            ind=[]
            for i in range(len(nums)):
                if nums[i]==0:
                    ind.append(i)
                else:
                    mul*=nums[i]
            for i in ind:
                answer[i]=mul
        elif nums.count(0)>1:
            answer=[0 for i in range(len(nums))]
        else:
            import numpy
            mul=numpy.prod(nums)
            answer=[int(mul/i) for i in nums]
        
        return answer