class Solution:
    def singleNumber(self, nums: List[int]) -> List[int]:
        
        ans = []
        d={}
        for i in nums:
            #print(d,i)
            if i in d.keys():
                ans.remove(i)
            else:
                d[i]=1
                ans.append(i)
        return ans            