//TLE
class Solution {
    private static boolean f(char[][] board , int[][] visited, String word, int letterind, int row, int col){
        if (letterind == word.length()){
            return true; 
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col] == 1 || board[row][col] != word.charAt(letterind)) {
            return false; 
        }
        visited[row][col] = 1;
        boolean found = f(board, visited, word, letterind + 1, row + 1, col) ||
                        f(board, visited, word, letterind + 1, row - 1, col) ||
                        f(board, visited, word, letterind + 1, row, col + 1) ||
                        f(board, visited, word, letterind + 1, row, col - 1);

        visited[row][col] = 0;
        return found;
    }
    public List<String> findWords(char[][] board, String[] words) {
        int[][] visited = new int[board.length][board[0].length];
        for (int[] row : visited) {
            Arrays.fill(row, 0); 
        }
        ArrayList<String> ans = new ArrayList<>();
        

        for (String word:words) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (f(board, visited, word, 0, i, j)) {
                        if (ans.indexOf(word)==-1) ans.add(word); 
                    }
                }
            }
        }
        return ans;
    }
}
