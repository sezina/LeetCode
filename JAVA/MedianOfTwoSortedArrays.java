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

// using find kth min, O(log(m+n))
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int alen = A.length, blen = B.length;
        int k = (alen + blen) / 2;
        if ((alen + blen) % 2 == 1) {
            return (double)findKth(k + 1, A, 0, alen, B, 0, blen);
        }
        return ((double)findKth(k, A, 0, alen, B, 0, blen) + (double)findKth(k+1, A,0,alen, B,0,blen)) / 2;
    }
    
    private int findKth(int k, int[] A, int al, int ah, int[]B, int bl, int bh) {
        if (ah - al > bh - bl)
            return findKth(k, B, bl, bh, A, al, ah);
        if (ah-al == 0)
            return B[bl + k - 1];
        if (k == 1)
            return Math.min(A[al], B[bl]);
        int pa = Math.min(k/2, ah-al), pb = k - pa;
        if (A[al+pa-1] < B[bl+pb-1])
            return findKth(k - pa, A, al + pa, ah, B, bl, bh);
        else if (A[al+pa-1] > B[bl+pb-1])
            return findKth(k-pb, A, al, ah, B, bl+pb, bh);
        else
            return A[al+pa-1];
    }
}

// O(log(min(m,n)))
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int n = A.length, m = B.length;
        if (n > m)
            return findMedianSortedArrays(B, A);
        
        int k = (n + m - 1) / 2;
        int l = 0, r = Math.min(k, n);  // r is n, NOT n - 1, this is important
        while (l < r) {
            int midA = (l + r) / 2;
            int midB = k - midA;
            if (midB > k || A[midA] < B[midB])
                l = midA + 1;
            else r = midA;
        }
        
        int a = Math.max(l > 0 ? A[l - 1] : Integer.MIN_VALUE, k - l >= 0 ? B[k - l] : Integer.MIN_VALUE);
        if (((n + m) & 1) == 1)
            return (double)a;
        
        int b = Math.min(l < n ? A[l] : Integer.MAX_VALUE, k - l + 1 < m ? B[k - l + 1] : Integer.MAX_VALUE);
        return (a + b) / 2.0;
    }
}