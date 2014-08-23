public class Solution {
    private boolean[] used;
    private StringBuffer sb = new StringBuffer();
    private int num;
    private int threshold;
    private int count;
    public String getPermutation(int n, int k) {
        if (n == 0) return "";
        int appearFirstCount = 1, beginNum;
        for (int i = 1; i < n; i++)
            appearFirstCount *= i;
        if (k % appearFirstCount == 0) {
            beginNum = k / appearFirstCount;
            sb.append(beginNum);
            for (int i = n; i > 0; i--) {
                if (i != beginNum) sb.append(i);
            }
            return sb.toString();
        }
        beginNum = k / appearFirstCount + 1;
        threshold = k % appearFirstCount;
        count = 0;
        used = new boolean[n + 1];
        used[beginNum] = true;
        sb.append(beginNum);
        num = n;
        permutation();
        return sb.toString();
    }
    
    private void permutation() {
        if (sb.length() == num) {
            count++;
            return;
        }
        for (int i = 1; i <= num; i++) {
            if (used[i]) continue;
            sb.append(i);
            used[i] = true;
            permutation();
            if (count == threshold) return;
            used[i] = false;
            sb.setLength(sb.length() - 1);
        }
    }
}