from typing import List

class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        ans = []
        n = len(intervals)
        intervals.sort() # Sort the intervals based on the start time
        
        # Initialize the first interval
        prev0, prev1 = intervals[0][0], intervals[0][1]

        for i in range(1, n):
            # Check for overlap
            if intervals[i][0] >= prev0 and intervals[i][0] <= prev1:
                # Merge the intervals
                prev1 = max(prev1, intervals[i][1])
            else:
                # No overlap, add the previous interval to the result and make the cur intervals as previos intervals
                ans.append([prev0, prev1])
                prev0, prev1 = intervals[i][0], intervals[i][1]

        ans.append([prev0, prev1])

        return ans
