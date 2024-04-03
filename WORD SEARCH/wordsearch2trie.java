class Solution {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    private void buildTrie(TrieNode root, String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, StringBuilder path, Set<String> result) {
        char ch = board[i][j];
        if (ch == '#' || node.children[ch - 'a'] == null)
            return;

        board[i][j] = '#';
        node = node.children[ch - 'a'];
        path.append(ch);
        if (node.isEnd) {
            result.add(path.toString());
        }

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                dfs(board, x, y, node, path, result);
            }
        }

        path.deleteCharAt(path.length() - 1);
        board[i][j] = ch;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            buildTrie(root, word);
        }

        Set<String> result = new HashSet<>();
        StringBuilder path = new StringBuilder();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, path, result);
            }
        }

        return new ArrayList<>(result);
    }
}
