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