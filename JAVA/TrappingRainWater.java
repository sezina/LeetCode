public class Solution {
    public int trap(int[] A) {
        if (A.length < 3) return 0;
        int total = 0, temp = 0, maxi = 0;
        for (int i = 1; i < A.length; i++)
            if (A[maxi] < A[i])
                maxi = i;
        
        for (int i = 0; i < maxi; i++) {
            if (A[i] > temp) temp = A[i];
            else total += (temp - A[i]);
        }
        temp = 0;
        for (int i = A.length - 1; i > maxi; i--) {
            if (A[i] > temp) temp = A[i];
            else total += (temp - A[i]);
        }
        
        return total;
    }
}