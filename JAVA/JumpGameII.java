public class Solution {
    public int jump(int[] A) {
        if (A.length < 2) return 0;
        int target = A.length;
        int count = 0;
        while (target > 1) {
            int temp = jumpHelper(A, target);
            if (temp == target) return 0;
            target = temp;
            count++;
        }
        return count;
    }
    
    private int jumpHelper(int[] A, int target) {
        int step = A[0];
        if (step >= target) return 0;
        for (int i = 0; step > 0; i++) {
            if (i + step >= target) {
                target = i;
                break;
            }
            step = Math.max(step - 1, A[i]);
        }
        return target;
    }
}