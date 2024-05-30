class Solution:
    def countTriplets(self, arr: List[int]) -> int:
        count = 0
        
        for i in range(len(arr)):
            val = arr[i]
            
            for k in range(i + 1, len(arr)):
                val ^= arr[k]
                
                if val == 0:
                    count += (k - i)
        
        return count