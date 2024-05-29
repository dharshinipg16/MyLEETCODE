class Solution:
    def numSteps(self, s: str) -> int:
        num = int(s,2)
        count=0
        if (num==1):
            return count
        else:
            while (num!=1):
                if (num%2==0):
                    num = num//2
                    count+=1
                else:
                    num=(num+1) // 2
                    count+=2
        return count