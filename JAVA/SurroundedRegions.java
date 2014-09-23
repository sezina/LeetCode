public class Solution {
    private static int[] rone = {0,-1,1,0};
    private static int[] cone = {-1,0,0,1};
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int rs = board.length, cs = board[0].length;
        boolean[][] flag = new boolean[rs][cs];
        for (int i = 0; i < rs; i++) {
            for (int j = 0; j < cs; j++) {
                if (i == 0 || j == 0) {
                    if (board[i][j] == 'O') {
                        flag[i][j] = true;
                        setFlag(board, flag, i, j);
                    }
                } else if (flag[i][j]) setFlag(board, flag, i, j);
            }
            for (int j = cs - 1; j >= 0; j--)
                if (flag[i][j]) setFlag(board, flag, i, j);
        }
        for (int i = rs - 1; i >=0; i--) {
            for (int j = cs - 1; j >= 0; j--) {
                if (i == rs - 1 || j == cs - 1) {
                    if (board[i][j] == 'O') {
                        flag[i][j] = true;
                        setFlag(board, flag, i, j);
                    }
                } else if (flag[i][j]) setFlag(board, flag, i, j);
            }
            for (int j = 0; j < cs; j++)
                if (flag[i][j]) setFlag(board, flag, i, j);
        }
        
        for (int i = 0; i < rs; i++)
            for (int j = 0; j < cs; j++)
                if (board[i][j] == 'O' && !flag[i][j]) board[i][j] = 'X';
    }
    
    private void setFlag(char[][] board, boolean[][] flag, int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + rone[i], nc = c + cone[i];
            if (nr < 0 || nr >= board.length || nc < 0 || nc >= board[0].length) continue;
            if (board[nr][nc] == 'O')
                flag[nr][nc] = true;
        }
    }

}