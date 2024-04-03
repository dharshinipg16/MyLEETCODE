class Solution {
    private static boolean f(char[][] board , int[][] visited, String word, int letterind, int row, int col){
        if (letterind == word.length()){
            return true; // All characters in the word are found
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col] == 1 || board[row][col] != word.charAt(letterind)) {
            return false; // Out of bounds or already visited or incorrect character
        }
        
        // Mark the current cell as visited
        visited[row][col] = 1;
        
        // Explore neighbors
        boolean found = f(board, visited, word, letterind + 1, row + 1, col) ||
                        f(board, visited, word, letterind + 1, row - 1, col) ||
                        f(board, visited, word, letterind + 1, row, col + 1) ||
                        f(board, visited, word, letterind + 1, row, col - 1);
        
        // Unmark the current cell after exploration
        visited[row][col] = 0;
        
        return found;
    }
    public boolean exist(char[][] board, String word) {
        int[][] visited = new int[board.length][board[0].length];
        for (int[] row : visited) {
            Arrays.fill(row, 0); // Initialize all cells as unvisited
        }
        // Iterate through each cell in the board to start the search
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (f(board, visited, word, 0, i, j)) {
                    return true; // If a path is found starting from this cell, return true
                }
            }
        }
        return false; // If no path is found, return false
    }
}
