public class Solution {
    public void nextPermutation(int[] num) {
        int maxIndex = num.length - 1, i, target = 0;
        for (i = num.length - 2; i >= 0; i--) {
            if (num[i] >= num[maxIndex]) maxIndex = i;
            else {
                target = i;
                break;
            }
        }
        if (i < 0) Arrays.sort(num);
        else {
            int min = Integer.MAX_VALUE, minIndex = target + 1;
            for (int j = target + 1; j < num.length; j++) {
                if (num[j] > num[target] && num[j] - num[target] < min) {
                    min = num[j] - num[target];
                    minIndex = j;
                }
            }
            int temp = num[target];
            num[target] = num[minIndex];
            num[minIndex] = temp;
            Arrays.sort(num, target + 1, num.length);
        }
    }
}