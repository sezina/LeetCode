public class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Integer>[] sets = new HashSet[27];
        for (int i = 0; i < 27; i++)
            sets[i] = new HashSet<Integer>();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                if (sets[i].contains(board[i][j] - '0')) return false;
                else sets[i].add(board[i][j] - '0');
                if (sets[9 + j].contains(board[i][j] - '0')) return false;
                else sets[9 + j].add(board[i][j] - '0');
                int block = i / 3 * 3 + j / 3;
                if (sets[18 + block].contains(board[i][j] - '0')) return false;
                else sets[18 + block].add(board[i][j] - '0');
            }
        }
        return true;
    }
}