class Solution:
    def reverse(self, x: int) -> int:
        num=str(x)
        new=""
        if (num[0]=="-"):
            new="-"
            new+=num[-1:0:-1]
        else:
            new=num[-1::-1]
        new=int(new)
        if (new<=(-2**31) or new>=(2**31 -1)):
            new=0
        
        return int(new)