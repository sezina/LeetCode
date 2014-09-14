public class Solution {
    int result;
    boolean isFind;
    public int threeSumClosest(int[] num, int target) {
        result = num[0] + num[1] + num[2];
        isFind = false;
        sumHelper(num, target, 0, 0, 0);
        return result;
    }
    
    private void sumHelper(int[] num, int target, int sum, int index, int count) {
        if (count == 3) {
            if (result == target) isFind = true;
            if (Math.abs(target - sum) < Math.abs(result - target))
                result = sum;
            return;
        }
        
        for (int i = index; i < num.length && !isFind; i++) {
            sum += num[i];
            sumHelper(num, target, sum, i + 1, count + 1);
            sum -= num[i];
        }
    }
}

// iterative solution
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int max = num[0] + num[1] + num[2];
        if (num.length == 3) return max;
        int n = num.length;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = num[i] + num[j] + num[k];
                if (Math.abs(target - sum) < Math.abs(target - max)) {
                    max = sum;
                    if (max == target) return max;
                }
                if (sum > target) k--;
                else j++;
            }
        }
        return max;
    }
}