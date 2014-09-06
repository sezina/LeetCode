// O(m+n) space
public class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<Integer>();
        Set<Integer> cols = new HashSet<Integer>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (int r : rows) 
            for (int i = 0; i < matrix[0].length; i++)
                matrix[r][i] = 0;
        for (int c : cols)
            for (int i = 0; i < matrix.length; i++)
                matrix[i][c] = 0;
    }
}