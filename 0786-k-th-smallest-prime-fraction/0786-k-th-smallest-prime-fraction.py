class Solution:
    def kthSmallestPrimeFraction(self, arr: List[int], k: int) -> List[int]:
        d={}
        res=[]
        for i in range(len(arr)):
            for j in range(i+1,len(arr)):
                a=arr[i]/arr[j]
                res.append(a)
                d[a] = [arr[i],arr[j]]
        res.sort()
        return d[res[k-1]]