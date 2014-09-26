// O(n + m)
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int alen = A.length, blen = B.length;
        if (alen == 0 && blen == 0) return 0.0;
        int i = 0, j = 0, a = 0, b = 0, target = (alen + blen) / 2, count = 0, temp;
        while (i < alen && j < blen && b == 0) {
            count++;
            if (A[i] < B[j]) {
                temp = A[i];
                i++;
            } else {
                temp = B[j];
                j++;
            }
            if (count == target) a = temp;
            if (count == target + 1) b = temp;
        }
        while (i < alen && b == 0) {
            count++;
            if (count == target) a = A[i];
            if (count == target + 1) b = A[i];
            i++;
        }
        while (j < blen && b == 0) {
            count++;
            if (count == target) a = B[j];
            if (count == target + 1) b = B[j];
            j++;
        }
        if ((alen + blen) % 2 == 0)
            return ((double)a + b) / 2;
        return (double)b;
    }
}