public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(0);
        int mask = 1;
        for (int i = 0; i < n; i++) {
            int rn = result.size();
            for (int j = rn - 1; j >= 0; j--)
                result.add(result.get(j) | mask);
            mask = mask << 1;
        }
        return result;
    }
}