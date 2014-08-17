public class Solution {
    public int removeDuplicates(int[] A) {
        int removeCount = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] == A[i - removeCount - 1] && A[i] == A[i - removeCount - 2])
                removeCount++;
            else
                A[i - removeCount] = A[i];
        }
        return A.length - removeCount;
    }
}