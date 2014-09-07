public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (obstacleGrid[i][j] == 1)
                    result[i][j] = 0;
                else {
                    if (i == 0 && j == 0) result[i][j] = 1;
                    else if (i == 0 && j != 0) result[i][j] = result[i][j - 1];
                    else if (i != 0 && j == 0) result[i][j] = result[i - 1][j];
                    else result[i][j] = result[i][j - 1] + result[i - 1][j];
                }
            }
        }
        return result[row - 1][col - 1];
    }
}