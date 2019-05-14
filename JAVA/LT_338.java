/**
 * #338
 * url: https://leetcode.com/problems/counting-bits/
 */

public class LT_338 {
    static class Solution {
        public int[] countBits(int num) {
            int[] result = new int[num + 1];

            int seeback = 1;
            int sc = 0;

            for (int i = 1; i <= num; i++) {
                result[i] = result[i - seeback] + 1;
                sc++;
                if (sc >= seeback) {
                    sc = 0;
                    seeback *= 2;
                }
            }

            return result;
        }
    }
}