class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] profit = new int[2 + 1][n];
        
        for (int i = 1; i <= 2; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < n; j++) {
                profit[i][j] = Math.max(profit[i][j - 1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, profit[i - 1][j] - prices[j]);
            }
        }

        return profit[2][n - 1];
    }
}