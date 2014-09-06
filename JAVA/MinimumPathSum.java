public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int[][] ps = new int[grid.length][grid[0].length];
        ps[0][0] = grid[0][0];
        int sum = 0, row = ps.length, col = ps[0].length;
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