class Solution {
    private int f(int[][] grid, int i, int j,int[][] dp) {
        if (i==0 && j==0) return dp[0][0]=grid[0][0];
        if (i<0 || j<0) return 100000000;
        
        if (dp[i][j]!=-1) return dp[i][j];
        
        int up = grid[i][j] + f(grid,i-1,j,dp);
        int left = grid[i][j] + f(grid,i,j-1,dp);
        
        return dp[i][j]=Math.min(up,left);
    }
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m= grid[0].length;
        int[][] dp = new int[n+1][m+1];
        for (int[] row:dp) {
            Arrays.fill(row,-1);
        }
        return f(grid,n-1,m-1,dp);
    }
}