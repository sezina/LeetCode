public class Solution {
    private static int[] rone = {0,0,1,-1};
    private static int[] cone = {1,-1,0,0};
    public boolean exist(char[][] board, String word) {
        if (word.isEmpty()) return true;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if (dfs(board, word, visited, i, j, 1)) return true;
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, boolean[][] visited, int r, int c, int index) {
        if (index == word.length()) return true;
        for (int i = 0; i < 4; i++) {
            int nr = r + rone[i], nc = c + cone[i];
            if (nr < 0 || nr >= board.length || nc < 0 || nc >= board[0].length) continue;
            if (!visited[nr][nc]) {
                if (board[nr][nc] == word.charAt(index)) {
                    visited[nr][nc] = true;
                    if (dfs(board, word, visited, nr, nc, index+1)) return true;
                    visited[nr][nc] = false;
                }
            }
        }
        return false;
    }
}