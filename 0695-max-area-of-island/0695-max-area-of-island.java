class Solution {
    public int dfs (int i,int j,int n,int m,int[][] grid) {
        if (i<0 || j<0 ||i>=n ||j>=m) return 0;
        if (grid[i][j]==1) {
            grid[i][j]=2; //visited
            int sum=1;
            int up = dfs(i-1,j,n,m,grid);
            int down = dfs(i+1,j,n,m,grid);
            int left = dfs(i,j-1,n,m,grid);
            int right = dfs(i,j+1,n,m,grid);
            sum += (up+down+right+left);
            return sum;
        }
        return 0;
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m =grid[0].length;
        int area=0;
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++){
                if (grid[i][j]==1){
                    int temparea = dfs(i,j,n,m,grid);
                    area = Math.max(area,temparea);
                }
            }
        }
        return area;
    }
}