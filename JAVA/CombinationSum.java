public class Solution {
    List<List<Integer>> results;
    List<Integer> oneRst;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        results = new LinkedList<List<Integer>>();
        oneRst = new ArrayList<Integer>();
        Arrays.sort(candidates);
        if (target < candidates[0]) return results;
        combineHelper(candidates, target, 0, 0);
        return results;
    }
    
    private void combineHelper(int[] candidates, int target, int sum, int startIndex) {
        if (sum > target) return;
        if (sum == target) {
            results.add(new ArrayList<Integer>(oneRst));
            return;
        }
        
        for (int i = startIndex; i < candidates.length; i++) {
            oneRst.add(candidates[i]);
            sum += candidates[i];
            combineHelper(candidates, target, sum, i);
            sum -= candidates[i];
            oneRst.remove(oneRst.size() - 1);
        }
    }
}

// another thought
public class Solution {
    List<List<Integer>> results;
    List<Integer> oneRst;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        results = new LinkedList<List<Integer>>();
        oneRst = new ArrayList<Integer>();
        Arrays.sort(candidates);
        if (target < candidates[0]) return results;
        combineHelper(candidates, target, 0);
        return results;
    }
    
    private void combineHelper(int[] candidates, int target, int startIndex) {
        for (int i = startIndex; i < candidates.length; i++) {
            if (candidates[i] == target) {
                oneRst.add(candidates[i]);
                results.add(new ArrayList<Integer>(oneRst));
                oneRst.remove(oneRst.size() - 1);
                return;
            } else if (candidates[i] < target) {
                oneRst.add(candidates[i]);
                combineHelper(candidates, target - candidates[i], i);
                oneRst.remove(oneRst.size() - 1);
            } else return;
        }
    }
}