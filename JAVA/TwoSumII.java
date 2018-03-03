/**
 * 167
 *
 * @author sezina
 * @since 3/3/18
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int lo = 0, hi = numbers.length - 1;
        while (numbers[lo] + numbers[hi] != target) {
            while (numbers[lo] + numbers[hi] > target) hi--;
            while (numbers[lo] + numbers[hi] < target) lo++;
        }
        return new int[]{lo+1, hi+1};
    }
}
