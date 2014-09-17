// recursive solution, same as NQueens
public class Solution {
    int count;
    boolean[][] grid;
    int size;
    public int totalNQueens(int n) {
        if (n == 1) return 1;
        if (n < 4) return 0;
        count = 0;
        size = n;
        grid = new boolean[n][n];
        helper(0);
        return count;
    }
    
    private void helper(int row) {
        for (int i = 0; i < size; i++) {
            if (isValid(row, i)) {
                if (row == size - 1) {
                    count++;
                    continue;
                }
                grid[row][i] = true;
                helper(row + 1);
                grid[row][i] = false;
            }
        }
    }
    
    private boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++)
            if (grid[i][col]) return false;
        int i = row - 1, j = col - 1;
        while (i > -1 && j > -1) {
            if (grid[i][j]) return false;
            i--;
            j--;
        }
        i = row - 1;
        j = col + 1;
        while (i > -1 && j < size) {
            if (grid[i][j]) return false;
            i--;
            j++;
        }
        return true;
    }
}