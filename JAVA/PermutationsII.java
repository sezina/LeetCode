public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (num.length == 0) return results;
        List<Integer> oneRst = new ArrayList<Integer>();
        boolean[] used = new boolean[num.length];
        Arrays.sort(num);
        permute(num, results, oneRst, used);
        return results;
    }
    
    private void permute(int[] num, List<List<Integer>> results, List<Integer> oneRst, boolean[] used) {
        if (oneRst.size() == num.length) {
            List<Integer> rst = new ArrayList<Integer>(oneRst);
            results.add(rst);
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (used[i]) continue;
            if (i != 0 && num[i] == num[i - 1] && !used[i - 1])
                continue;
            oneRst.add(num[i]);
            used[i] = true;
            permute(num, results, oneRst, used);
            used[i] = false;
            oneRst.remove(oneRst.size() - 1);
        }
    }
}