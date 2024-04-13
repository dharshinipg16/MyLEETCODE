class Solution {
     int ans=0;
    class Pair{
        int row;
        int col;
        int time;
        public Pair(int row,int col,int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    public int bfs(int grid[][], Queue<Pair> q, int vis[][],int dr[],int dc[]){
        int max=0;
        while(!q.isEmpty()){
            Pair p = q.remove();
            int row = p.row;
            int col = p.col;
            int time = p.time;
            max = Math.max(time,max);
            for(int i=0;i<4;i++){
                int nr = row+dr[i];
                int nc = col+dc[i];
            if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length &&  grid[nr][nc]==1 && vis[nr][nc]==0){
                    grid[nr][nc]=2;
                    vis[nr][nc]=1;
                    ans++;
                    q.add(new Pair(nr,nc,time+1));
                }
            }   
        }
        return max;
    }
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int vis[][] = new int[m][n];
        int dr[] = {0,1,0,-1};
        int dc[] = {1,0,-1,0};
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2 && vis[i][j]==0){
                    vis[i][j]=1;
                    q.add(new Pair(i,j,0));
                }
            }
        }
        int ans = bfs(grid,q,vis,dr,dc);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)
                    return -1;
            }
        }
        return ans;
    }
}