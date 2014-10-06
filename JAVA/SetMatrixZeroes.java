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

// O(1) space
public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean rz = false, cz = false;
        for (int i = 0; i < matrix[0].length; i++)
            if (matrix[0][i] == 0) rz = true;
        for (int i = 0; i < matrix.length; i++)
            if (matrix[i][0] == 0) cz = true;
        
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for (int i = 0; i < matrix[0].length; i++) {
            if (cz && i == 0) continue;
            if (matrix[0][i] == 0) {
                for (int j = 0; j < matrix.length; j++)
                    matrix[j][i] = 0;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            
            if (matrix[i][0] == 0) {
                for (int j = 0; j < matrix[0].length; j++)
                    matrix[i][j] = 0;
            }
        }
        if (rz)
            for (int i = 0; i < matrix[0].length; i++) matrix[0][i] = 0;
        if (cz)
            for (int i = 0; i < matrix.length; i++) matrix[i][0] = 0;
    }
}