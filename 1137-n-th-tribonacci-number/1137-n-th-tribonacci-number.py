class Solution:
    def tribonacci(self, n: int) -> int:
        a=[0,1,1]
        if n<=2 :
            return a[n]
        
        #3=1,4=2
        for i in range(3,n+1):
            a.append(a[i-1]+a[i-2]+a[i-3])
        return a[-1]
