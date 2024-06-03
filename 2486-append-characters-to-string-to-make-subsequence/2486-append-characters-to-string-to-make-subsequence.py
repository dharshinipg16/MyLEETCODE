class Solution:
    def appendCharacters(self, s: str, t: str) -> int:
        sindex,tindex = 0 ,0
        slen,tlen= len(s),len(t)
        while (sindex<slen) and (tindex<tlen) :
            if (s[sindex]==t[tindex]):
                tindex+=1
            sindex+=1
        return tlen-tindex
        
        
        
#         if (t in s):
#             return 0
#         count=0
#         for i in range(0,len(t)):
#             if (t[i] in s):
#                 if (i!=0 and s.index(t[i])<s.index(t[i-1])):
#                     count+=len(t)-i
#                     break
#             else:
#                 # t[i] not in s
#                 count+=len(t)-i
#                 break
        
#         return count