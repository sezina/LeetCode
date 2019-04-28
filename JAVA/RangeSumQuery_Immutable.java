/**
 * #303
 * url: https://leetcode.com/problems/range-sum-query-immutable/
 */

class NumArray {

    private int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) sum[i] = nums[i];
            else sum[i] = sum[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j] - (i == 0 ? 0 : sum[i - 1]);
    }
}