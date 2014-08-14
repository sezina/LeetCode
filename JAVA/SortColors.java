public class Solution {
    public void sortColors(int[] A) {
        int red = 0, white = 0, blue = 0, i, j;
        for (i = 0; i < A.length; i++) {
            if (A[i] == 0) red++;
            else if (A[i] == 1) white++;
            else blue++;
        }
        for (i = 0; i < A.length; i++) {
            if (i < red) A[i] = 0;
            else if (i < red + white) A[i] = 1;
            else A[i] = 2;
        }
    }
}

public class Solution2 {
    public void sortColors(int[] A) {
        int f = 0, b = A.length - 1;
        for (int i = 0; i <= b; i++) {
            if (A[i] == 0) {
                while(f < i && A[f] == 0) f++;
                if (f != i) {
                    A[i] = A[f];
                    A[f] = 0;
                    i--;
                }
            } else if (A[i] == 2) {
                while(b > i && A[b] == 2) b--;
                if (b != i) {
                    A[i] = A[b];
                    A[b] = 2;
                    i--;
                }
            }
        }
    }
}

public class Solution3 {
    public void sortColors(int[] A) {
        int j = -1, k = -1, temp;
        for (int i = 0; i < A.length; i++) {
            temp = A[i];
            A[i] = 2;
            if (temp == 0) {
                A[++j] = 1;
                A[++k] = 0;
            } else if (temp == 1) {
                A[++j] = 1;
            }
        }
    }
}