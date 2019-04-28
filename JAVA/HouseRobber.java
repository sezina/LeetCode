/**
 * #198
 * url: https://leetcode.com/problems/house-robber/
 */

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] maxMoney = new int[nums.length];

        maxMoney[0] = nums[0];
        maxMoney[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            maxMoney[i] = Math.max(maxMoney[i - 1], maxMoney[i - 2] + nums[i]);
        }

        return maxMoney[nums.length - 1];
    }
}