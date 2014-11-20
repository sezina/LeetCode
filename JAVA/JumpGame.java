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

// more neat code
public class Solution {
    public boolean canJump(int[] A) {
        if (A.length < 2) return true;
        int step = A[0];
        for (int i = 0; step > 0 && step + i < A.length; i++)
            step = Math.max(step - 1, A[i]);
        return step != 0;
    }
}

// more clear
public class Solution {
    public boolean canJump(int[] A) {
        if (A.length < 2) return true;
        int step = A[0];
        for (int i = 1; i < A.length; i++) {
            step--;
            if (step == -1) return false;
            step = Math.max(step, A[i]);
            if (step + i >= A.length - 1) return true;
        }
        return true;
    }
}