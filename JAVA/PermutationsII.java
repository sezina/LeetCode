// not good
public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (num.length == 0) return results;
        List<Integer> oneRst = new ArrayList<Integer>();
        Set<Double> filter = new HashSet<Double>();
        boolean[] used = new boolean[num.length];
        permute(num, results, oneRst, filter, used);
        return results;
    }
    
    private void permute(int[] num, List<List<Integer>> results, List<Integer> oneRst, Set<Double> filter, boolean[] used) {
        if (oneRst.size() == num.length) {
            double result = 0;
            for (Integer i : oneRst)
                result = result * 10 + i;
            if (!filter.contains(result)) {
                filter.add(result);
                List<Integer> rst = new ArrayList<Integer>(oneRst);
                results.add(rst);
            }
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (used[i]) continue;
            oneRst.add(num[i]);
            used[i] = true;
            permute(num, results, oneRst, filter, used);
            used[i] = false;
            oneRst.remove(oneRst.size() - 1);
        }
    }
}