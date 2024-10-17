class Solution {
    public void dfs (char[][] grid, int[][] vis, int i, int j,int n,int m) {
        if (i<0 || j<0 || i>=n || j>=m || grid[i][j]=='0' || vis[i][j]==1) {
            return;
        }
        vis[i][j] = 1;
        dfs (grid,vis,i-1,j,n,m);
        dfs (grid,vis,i+1,j,n,m);
        dfs (grid,vis,i,j-1,n,m);
        dfs (grid,vis,i,j+1,n,m);
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int c = 0;
        int [][] vis = new int[n][m];

        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (grid[i][j]!='0') {
                    if (vis[i][j] == 0) {
                        c++;
                        dfs(grid,vis,i,j,n,m);
                    }
                }
            }
        }
        return c;
    }
}