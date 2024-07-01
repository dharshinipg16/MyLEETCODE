class Solution:
    def printVertically(self, s: str) -> List[str]:
        lst = list(s.split(" "))
        ans = []
        for word in lst:
            for i in range(len(word)):
                if (len(ans)<=i):
                    x=lst.index(word)
                    s= ((x) * " ")
                    ans.append(s+word[i])
                else:
                    ans[i]+=word[i]
            if (len(word)<len(ans)):
                for j in range(len(word),len(ans)):
                    ans[j]+=" "
        
        ans = [i.rstrip() for i in ans]
        return ans
        
            