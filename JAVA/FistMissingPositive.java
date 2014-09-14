public class Solution {
    public int firstMissingPositive(int[] A) {
        Set<Integer> exist = new HashSet<Integer>();
        int positiveCount = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                positiveCount++;
                exist.add(A[i]);
            }
        }
        for (int i = 1; i <= positiveCount; i++)
            if (!exist.contains(i)) return i;
        return positiveCount + 1;
    }
}