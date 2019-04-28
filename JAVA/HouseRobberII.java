/**
 * #213
 * url: https://leetcode.com/problems/house-robber-ii/
 */

public class LT_213 {
    class Solution {
        public int rob(int[] nums) {
            if (nums.length == 0) return 0;
            if (nums.length == 1) return nums[0];

            int[] maxMoney = new int[nums.length];

            // rob #1
            maxMoney[0] = nums[0];
            maxMoney[1] = nums[0];

            for (int i = 2; i < nums.length - 1; i++) {
                maxMoney[i] = Math.max(maxMoney[i - 1], maxMoney[i - 2] + nums[i]);
            }

            int round_1 = maxMoney[nums.length - 2];

            // do not rob #1
            maxMoney[0] = 0;
            maxMoney[1] = nums[1];
            for (int i = 2; i < nums.length; i++) {
                maxMoney[i] = Math.max(maxMoney[i - 1], maxMoney[i - 2] + nums[i]);
            }

            return Math.max(round_1, maxMoney[nums.length - 1]);
        }
    }
}