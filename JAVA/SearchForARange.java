public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] answer = {-1,-1};
        int mid, low = 0, high = A.length - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (target == A[mid] && (mid == 0 || (mid > 0 && A[mid - 1] < target))) {
                answer[0] = mid;
                low = mid;
                high = A.length - 1;
                break;
            }
            if (target <= A[mid]) high = mid - 1;
            else low = mid + 1;
        }
        while (low <= high) {
            mid = (low + high) / 2;
            if (target == A[mid] && (mid == A.length - 1 || (mid < A.length - 1 && A[mid + 1] > target))) {
                answer[1] = mid;
                break;
            }
            if (target < A[mid]) high = mid - 1;
            else low = mid + 1;
        }
        return answer;
    }
}