class Solution {
    public int islandPerimeter(int[][] grid) {
        int peri = 0;
        
        // Iterate through each cell in the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // If the cell is land
                if (grid[i][j] == 1) {
                    // Check the four possible directions
                    // Check top
                    if (i == 0 || grid[i - 1][j] == 0) {
                        peri++;
                    }
                    // Check bottom
                    if (i == grid.length - 1 || grid[i + 1][j] == 0) {
                        peri++;
                    }
                    // Check left
                    if (j == 0 || grid[i][j - 1] == 0) {
                        peri++;
                    }
                    // Check right
                    if (j == grid[0].length - 1 || grid[i][j + 1] == 0) {
                        peri++;
                    }
                }
            }
        }
        
        return peri;
    }
}