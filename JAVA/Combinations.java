public class Solution {
    private List<List<Integer>> results;
    private Stack<Integer> oneRst;
    private int num;
    private int threshold;
    public List<List<Integer>> combine(int n, int k) {
        results = new ArrayList<List<Integer>>();
        oneRst = new Stack<Integer>();
        num = n;
        threshold = k;
        combineHelper(1);
        return results;
    }
    
    private void combineHelper(int start) {
        if (oneRst.size() == threshold) {
            List<Integer> rst = new ArrayList<Integer>(oneRst);
            results.add(rst);
            return;
        }
        for (int i = start; i <= num; i++) {
            oneRst.push(i);
            combineHelper(i + 1);
            oneRst.pop();
        }
    }
}