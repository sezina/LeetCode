public class Solution {
    public void solveSudoku(char[][] board) {
        dfs(board, 0);
    }
    
    private boolean dfs(char[][] board, int pos) {
        if (pos == 81) return true;
        int r = pos / 9;
        int c = pos % 9;
        if (board[r][c] == '.') {
            for (char i = '1'; i <= '9'; i++) {
                board[r][c] = i;
                if (valid(board, pos) && dfs(board, pos + 1))
                    return true;
                board[r][c] = '.';
            }
        } else {
            return dfs(board, pos + 1);
        }
        return false;
    }
    
    private boolean valid(char[][] board, int pos) {
        int r = pos / 9;
        int c = pos % 9;
        for (int i = 0; i < 9; i++) 
            if (i != c && board[r][i] == board[r][c])
                return false;
        for (int i = 0; i < 9; i++)
            if (i != r && board[i][c] == board[r][c])
                return false;
        int baser = r / 3 * 3;
        int basec = c / 3 * 3;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (i + baser != r && j + basec != c && board[i + baser][j + basec] == board[r][c])
                    return false;
        return true;
    }
}