public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0][0] > target) return false;
        int i;
        for (i = 1; i < matrix.length && matrix[i][0] <= target; i++);
        i -= 1;
        int low = 0, high = matrix[i].length - 1, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (matrix[i][mid] == target) return true;
            if (matrix[i][mid] > target)
                high = mid - 1;
            else 
                low = mid + 1;
        }
        return false;
    }
}