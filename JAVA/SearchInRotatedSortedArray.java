// naive solution, O(n)
public class Solution {
    public int search(int[] A, int target) {
        for (int i = 0; i < A.length; i++)
            if (A[i] == target) return i;
        return -1;
    }
}

// binary search
public class Solution {
    public int search(int[] A, int target) {
        int low = 0, high = A.length - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (A[high] < A[low]) {
                if (target == A[mid]) return mid;
                else if (target == A[low]) return low;
                else if (target == A[high]) return high;
                else if (target > A[mid]) {
                    if (A[low] < target && A[mid] > A[low]) low = mid + 1;
                    else if (A[mid] < A[low] && target < A[low]) low = mid + 1;
                    else high = mid - 1;
                } else if (target < A[mid]) {
                    if (A[mid] > A[low] && target < A[low]) low = mid + 1;
                    else high = mid - 1;
                }
            } else {
                if (A[mid] < target) low = mid + 1;
                else if (A[mid] > target) high = mid - 1;
                else return mid;
            }
        }
        return -1;
    }
}