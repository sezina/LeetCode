public class Solution {
    private boolean[] used;
    private List<List<Integer>> results;
    private Stack<Integer> oneRst;
    public List<List<Integer>> permute(int[] num) {
        results = new LinkedList<List<Integer>>();
        if (num.length == 0) return results;
        oneRst = new Stack<Integer>();
        used = new boolean[num.length];
        permuteHelper(num);
        return results;
    }
    
    private void permuteHelper(int[] num) {
        for (int i = 0; i < num.length; i++) {
            if (used[i]) continue;
            oneRst.push(num[i]);
            if (oneRst.size() == num.length) { // basic situation
                List<Integer> temp = new ArrayList<Integer>(oneRst);
                results.add(temp);
            } else {
                used[i] = true;
                permuteHelper(num);
                used[i] = false;
            }
            oneRst.pop();
        }
    }

    // another recursive method,
    // using a function invoke to deal with the basic situation
    private void permuteHelper2(int[] num) {
        if (oneRst.size() == num.length) {
            List<Integer> temp = new ArrayList<Integer>(oneRst);
            results.add(temp);
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (used[i]) continue;
            oneRst.push(num[i]);
            used[i] = true;
            permuteHelper(num);
            used[i] = false;
            oneRst.pop();
        }
    }
}