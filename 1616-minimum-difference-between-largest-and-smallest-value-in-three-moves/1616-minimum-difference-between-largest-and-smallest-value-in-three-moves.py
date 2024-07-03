class Solution:
        def minDifference(self, A):
            A.sort()
            return min(b - a for a, b in zip(A[:4], A[-4:]))
        
        
        

    