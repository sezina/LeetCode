import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 169
 *
 * @author sezina
 * @since 3/3/18
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums.length <= 2) return nums[0];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!map.containsKey(num))
                map.put(num, 1);
            map.put(num, map.get(num) + 1);
        }
        int mv = nums[0];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                mv = entry.getKey();
                break;
            }
        }
        return mv;
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
