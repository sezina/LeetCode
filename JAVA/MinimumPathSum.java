public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int[][] ps = new int[grid.length][grid[0].length];
        ps[0][0] = grid[0][0];
        int row = ps.length, col = ps[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j != 0)
                    ps[i][j] = grid[i][j] + ps[i][j - 1];
                else if (i != 0 && j == 0)
                    ps[i][j] = grid[i][j] + ps[i - 1][j];
                else if (i == 0 && j == 0) continue;
                else 
                    ps[i][j] = grid[i][j] + Math.min(ps[i - 1][j], ps[i][j - 1]);
            }
        }
        return ps[row - 1][col - 1];
    }
}

// in space
public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int row = grid.length, col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j != 0)
                    grid[i][j] += grid[i][j - 1];
                else if (i != 0 && j == 0)
                    grid[i][j] += grid[i - 1][j];
                else if (i == 0 && j == 0) continue;
                else 
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[row - 1][col - 1];
    }
}