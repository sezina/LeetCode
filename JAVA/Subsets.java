public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> rst = new ArrayList<Integer>();
        results.add(rst);
        for (int i = S.length - 1; i >= 0; i--) {
            int n = results.size();
            for (int j = 0; j < n; j++) {
                rst = new ArrayList<Integer>(results.get(j));
                rst.add(0, S[i]);
                results.add(rst);
            }
        }
        return results;
    }
}