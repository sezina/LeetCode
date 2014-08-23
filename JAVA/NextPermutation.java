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

// no need to sort, just rotate afterward
public class Solution {
    public void nextPermutation(int[] num) {
        int i, target = 0;
        for (i = num.length - 2; i >= 0; i--) {
            if (num[i] < num[i + 1]) {
                target = i;
                break;
            }
        }
        if (i < 0) rotate(num, 0, num.length - 1);
        else {
            int minIndex = target + 1;
            for (int j = num.length - 1; j > target; j--) {
                if (num[j] > num[target]) {
                    minIndex = j;
                    break;
                }
            }
            int temp = num[target];
            num[target] = num[minIndex];
            num[minIndex] = temp;
            rotate(num, target + 1, num.length - 1);
        }
    }
    
    private void rotate(int[] num, int start, int end) {
        int temp;
        for (int i = 0; i < (end - start + 1) / 2; i++) {
            temp = num[start + i];
            num[start + i] = num[end - i];
            num[end - i] = temp;
        }
    }
}