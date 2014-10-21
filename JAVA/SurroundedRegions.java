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

// bfs
public class Solution {
    private static int[] roffset = {0,-1,1,0};
    private static int[] coffset = {-1,0,0,1};
    public void solve(char[][] board) {
        if (board.length <= 2 || board[0].length <= 2) return;
        int rows = board.length, cols = board[0].length;
        boolean[][] flag = new boolean[rows][cols];
        Queue<int[]> queue = new ArrayDeque<int[]>();
        
        for (int i = 0; i < cols - 1; i++) {
            if (board[0][i] == 'O') {
                queue.add(new int[]{0, i});
                flag[0][i] = true;
            }
            if (board[rows - 1][cols - i - 1] == 'O') {
                queue.add(new int[]{rows - 1, cols-i-1});
                flag[rows - 1][cols-i-1] = true;
            }
        }
        
        for (int i = 1; i < rows; i++) {
            if (board[i][0] == 'O') {
                queue.add(new int[]{i, 0});
                flag[i][0] = true;
            }
            if (board[rows - i - 1][cols - 1] == 'O') {
                queue.add(new int[]{rows-i-1, cols-1});
                flag[rows-i-1][cols-1] = true;
            }
        }
        
        while (!queue.isEmpty()) {
            int[] cor = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cor[0] + roffset[i], nc = cor[1] + coffset[i];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                    if (board[nr][nc] == 'O' && flag[nr][nc] == false) {
                        queue.add(new int[]{nr, nc});
                        flag[nr][nc] = true;
                    }
                }
            }
        }
        
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (flag[i][j] == false && board[i][j] == 'O')
                    board[i][j] = 'X';
    }
}