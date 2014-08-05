public class Solution {
    public int removeDuplicates(int[] A) {
        int removeCount = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i - removeCount -1]) {
                removeCount++;
            } else {
                A[i - removeCount] = A[i];
            }
        }
        return A.length - removeCount;
    }
}