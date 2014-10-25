// naive O(n) solution
public class Solution {
    public int findMin(int[] num) {
        int min = num[0];
        for (int i = 1; i < num.length; i++)
            min = Math.min(min, num[i]);
        return min;
    }
}

// binary search
public class Solution {
    public int findMin(int[] num) {
        int low = 0, high = num.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (num[high] > num[low]) return num[low];
            else if (num[high] < num[low]) {
                if (num[mid] < num[low]) high = mid;
                else low = mid + 1;
            } else {
                if (num[mid] < num[low]) high = mid;
                else if (num[mid] > num[low]) low = mid + 1;
                else {
                    low++;
                    high--;
                }
            }
        }
        return num[low];
    }
}

// more neat code
public class Solution {
    public int findMin(int[] num) {
        int low = 0, high = num.length - 1;
        while (low < high) {
            if (num[high] > num[low]) return num[low];
            
            int mid = low + (high - low) / 2;
            if (num[mid] < num[low]) high = mid;
            else if (num[mid] > num[low]) low = mid + 1;
            else {
                if (num[high] < num[low]) low = mid + 1;
                else {
                    low++;
                    high--;
                }
            }
        }
        return num[low];
    }
}