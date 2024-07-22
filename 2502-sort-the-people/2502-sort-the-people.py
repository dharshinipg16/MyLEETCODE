class Solution:
    def sortPeople(self, names: List[str], heights: List[int]) -> List[str]:
        d={}
        for i in range(0,len(heights)):
            d[heights[i]]=names[i]
        heights.sort(reverse=True)
        ans = []
        for i in heights:
            ans.append(d[i])
        return ans