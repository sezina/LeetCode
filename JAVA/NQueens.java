// recursive solution
public class Solution {
    boolean[][] grid;
    int size;
    List<String[]> res;
    public List<String[]> solveNQueens(int n) {
        res = new ArrayList<String[]>();
        if (n == 0) return res;
        grid = new boolean[n][n];
        size = n;
        helper(0);
        return res;
    }
    
    private void helper(int row) {
        if (row == size) {
            String[] oneRes = new String[size];
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (grid[i][j]) sb.append('Q');
                    else sb.append('.');
                }
                oneRes[i] = sb.toString();
                sb.setLength(0);
            }
            res.add(oneRes);
            return;
        }
        
        for (int i = 0; i < size; i++) {
            if (isValid(row, i)) {
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