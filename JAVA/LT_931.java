/**
 * #931
 * url: https://leetcode.com/problems/minimum-falling-path-sum/
 */

public class LT_931 {
    static class Solution {
        public int minFallingPathSum(int[][] A) {
            int size = A.length;
            int[][] minfp = new int[size][size];

            System.arraycopy(A[0], 0, minfp[0], 0, size);
            for (int i = 1; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (j == 0) {
                        minfp[i][j] = A[i][j] + Math.min(minfp[i - 1][j], minfp[i - 1][j + 1]);
                    } else if (j == size - 1) {
                        minfp[i][j] = A[i][j] + Math.min(minfp[i - 1][j], minfp[i - 1][j - 1]);
                    } else {
                        minfp[i][j] = A[i][j] + Math.min(minfp[i - 1][j], minfp[i - 1][j - 1]);
                        minfp[i][j] = Math.min(minfp[i - 1][j + 1] + A[i][j], minfp[i][j]);
                    }
                }
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < size; i++)
                min = Math.min(min, minfp[size - 1][i]);
            return min;
        }
    }
}