public class Solution {
    public boolean canJump(int[] A) {
        if (A.length < 2) return true;
        int len = A.length, target = A.length - 1;
        for (int i = len - 2; i >= 0; i--)
            if (A[i] + i >= target) 
                target = i;
        return target == 0;
    }
}