class Solution:
    def minOperations(self, logs: List[str]) -> int:
        ans = 0
        
        for i in logs:
            if i[0] == "." and i[1] == ".":
                ans -=1
                if ans < 0:
                    ans = 0
            elif i[0] == "." and i[1] == "/":
                continue
            else:
                ans +=1
        return ans