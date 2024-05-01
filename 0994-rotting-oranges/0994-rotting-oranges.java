import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        
        // Add all rotten oranges to the queue and count fresh oranges
        int cntFresh = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j, 0}); // {x, y, time}
                } else if (grid[i][j] == 1) {
                    cntFresh++;
                }
            }
        }
        
        int time = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // Perform BFS
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int currTime = curr[2];
            time = Math.max(time, currTime); // Update time
            
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == 1) {
                    grid[newX][newY] = 2; // Mark as rotten
                    queue.offer(new int[]{newX, newY, currTime + 1}); // Add to queue with incremented time
                    cntFresh--; // Decrease count of fresh oranges
                }
            }
        }
        
        // If there are still fresh oranges left, return -1
        return cntFresh == 0 ? time : -1;
    }
}
