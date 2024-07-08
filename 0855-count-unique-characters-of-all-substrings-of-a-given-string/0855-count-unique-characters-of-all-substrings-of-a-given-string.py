class Solution:
    def uniqueLetterString(self, s: str) -> int:
        len_s = len(s)
        prev = [-1] * 27
        sec_prev = [-1] * 27
        ret = 0
        temp = 0
        
        for index in range(len_s):
            nchar = ord(s[index]) - ord('A')
            
            if prev[nchar] == -1:
                prev[nchar] = index
                temp += index + 1
            else:
                temp -= prev[nchar] - sec_prev[nchar]
                temp += index - prev[nchar]
                sec_prev[nchar] = prev[nchar]
                prev[nchar] = index
            
            ret += temp
        
        return ret
