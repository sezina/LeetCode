public class Solution {
    public int singleNumber(int[] A) {
        int one = 0, two = 0, three = 0;
        for (int a : A) {
            two = one & a ^ two;
            one ^= a;
            three = one & two;
            one ^= three;
            two ^= three;
        }
        return one;
    }
}