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