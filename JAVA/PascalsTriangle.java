public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows >= 1) {
            List<Integer> level = new ArrayList<Integer>();
            level.add(1);
            result.add(level);
            for (int i = 1; i < numRows; i++) {
                level = new ArrayList<Integer>();
                level.add(1);
                for (int j = 1; j < result.get(i - 1).size(); j++) {
                    level.add(result.get(i - 1).get(j) + result.get(i - 1).get(j - 1));
                }
                level.add(1);
                result.add(level);
            }
        }
        return result;
    }
}