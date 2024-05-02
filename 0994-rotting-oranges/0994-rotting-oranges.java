class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int cntfresh=0;
        Queue <int[]> q=new LinkedList<>(); 
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (grid[i][j]==2){
                    q.offer(new int[]{i,j,0});
                }
                if (grid[i][j]==1) {
                    cntfresh++;
                }
            }
        }
        
        int time=0;
        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
        //all rotten orange positions are stored
        while (!q.isEmpty()){
            int[] arr = q.poll();
            int i = arr[0];
            int j=arr[1];
            int currTime = arr[2];
            time = Math.max(time, currTime);
            for (int ii=0;ii<4;ii++){
                int nr = i+directions[ii][0];
                int nc = j+directions[ii][1];
                if (nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc]==1){
                    grid[nr][nc]=2;
                    q.offer(new int[]{nr,nc,currTime+1});
                    cntfresh--;
                    System.out.println(cntfresh);
                    
                }
            }
        }
        return (cntfresh==0)?time : -1;
    }
}