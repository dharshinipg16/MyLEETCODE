class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        if len(prices) < 2:
            return 0
        if len(prices) == 2:
            output = prices[1] - prices[0]
            return output if output > 0 else 0

        counter = 0
        profit = 0
        for i in range(1,len(prices)):
           profit+=max(0,prices[i]-prices[i-1])
        return profit