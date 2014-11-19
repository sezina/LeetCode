// O(n)
public class Solution {
    public int findMin(int[] num) {
        int min = num[0];
        for (int i = 1; i < num.length; i++)
            min = Math.min(num[i], min);
            
        return min;
    }
}

// O(lgn), too long
public class Solution {
    public int findMin(int[] num) {
        int min = num[0];
        int low = 0, high = num.length - 1;
        while (low < high) {
            if (low == high - 1) return Math.min(min, Math.min(num[low], num[high]));
            int mid = low + (high - low) / 2;
            if (num[mid] > num[low]) {
                if (num[mid] > num[high]) {
                    low = mid + 1;
                    min = Math.min(num[high], min);
                } else {
                    high = mid - 1;
                    min = Math.min(num[low], min);
                }
            } else if (num[mid] < num[low]) {
                high = mid - 1;
                min = Math.min(num[mid], min);
            }
        }
        return min;
    }
}

// another binary search
public class Solution {
    public int findMin(int[] num) {
        int low = 0, high = num.length - 1;
        if (num[low] < num[high]) return num[0];
        
        while (low < high - 1) {
            int mid = low + (high - low) / 2;
            if (num[mid] > num[low]) low = mid;
            else high = mid;
        }
        return num[high];
    }
}

public class Solution {
    public int findMin(int[] num) {
        int low = 0, high = num.length - 1;
        
        while (low < high) {
            if (num[low] < num[high]) return num[low];
            int mid = low + (high - low) / 2;
            if (num[mid] >= num[low]) low = mid + 1;
            else high = mid;
        }
        return num[low];
    }
}