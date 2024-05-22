class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res = []

        def dfs(i, part, palind):
            if i >= len(s):
                # if no leftover, add it to result
                if not palind: res.append(part)
                return
            
            substring = palind + s[i]
            # check if it is palindrome
            if substring == substring[::-1]:
                # 1) add palindrome to partition list and reset substring
                dfs(i + 1, part + [substring], "")
            
            # 2) don't add to partition list and keep the substring
            dfs(i + 1, part, substring)
        
        dfs(0, [], "")
        return res