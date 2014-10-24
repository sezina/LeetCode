// naive O(n) solution
public class Solution {
    public int findMin(int[] num) {
        int min = num[0];
        for (int i = 1; i < num.length; i++)
            min = Math.min(min, num[i]);
        return min;
    }
}

// binary search, worse case O(n)
public class Solution {
    public int findMin(int[] num) {
        int low = 0, high = num.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (num[mid] > num[low]) {
                if (num[mid] < num[high]) return num[low];
                else if (num[mid] == num[high]) high = mid;
                else low = mid;
            } else if (num[mid] < num[low]) {
                high = mid;
            } else {
                if (num[mid] < num[high]) return num[low];
                else if (num[mid] > num[high]) low = mid;
                else {
                    low++;
                    high--;
                }
            }
        }
        return Math.min(num[low], num[high]);
    }
}