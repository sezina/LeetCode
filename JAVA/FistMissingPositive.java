// O(n) time and O(n) space
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

// O(n) time and constant space
public class Solution {
    public int firstMissingPositive(int[] A) {
        if ((A.length == 1 && A[0] != 1) || A.length == 0) return 1;
        int temp, len = A.length;
        for (int i = 0; i < len; i++) {
            if (A[i] > 0 && A[i] <= len && A[A[i] - 1] != A[i]) {
                temp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = temp;
                if (A[i] != i + 1 && A[i] > 0 && A[i] <= len)
                    i--;
            }
        }
        for (int i = 0; i < len; i++)
            if (A[i] != i + 1) return i + 1;
        return len + 1;
    }
}