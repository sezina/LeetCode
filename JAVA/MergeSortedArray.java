public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        for (int i = m - 1, j = m + n - 1; i >= 0 && j >= 0; i--, j--)
            A[j] = A[i];
        int ai = n, bi = 0, ki = 0;
        while (ai < n + m && bi < n) {
            if (A[ai] < B[bi]) {
                A[ki] = A[ai];
                ki++;
                ai++;
            } else {
                A[ki] = B[bi];
                ki++;
                bi++;
            }
        }
        while (bi < n) {
            A[ki] = B[bi];
            ki++;
            bi++;
        }
    }
}