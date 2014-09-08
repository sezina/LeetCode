public class Solution {
    List<List<Integer>> res;
    int target;
    Set<String> visited;
    StringBuffer sb;
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        res = new ArrayList<List<Integer>>();
        visited = new HashSet<String>();
        sb = new StringBuffer();
        this.target = target;
        Arrays.sort(num);
        combine(num, new Stack<Integer>(), 0, 0);
        return res;
    }
    
    private void combine(int[] num, Stack<Integer> stack, int startI, int sum) {
        for (int i = startI; i < num.length; i++) {
            if (!stack.isEmpty() && num[i] < stack.peek()) continue;
            if (sum + num[i] == target) {
                stack.add(num[i]);
                sb.append(num[i]);
                String s = sb.toString();
                if (!visited.contains(s)) {
                    visited.add(s);
                    res.add(new ArrayList<Integer>(stack));
                }
                sb.setLength(sb.length() - digits(num[i]));
                stack.pop();
                return;
            } else if (sum + num[i] < target) {
                stack.add(num[i]);
                sb.append(num[i]);
                combine(num, stack, i + 1, sum + num[i]);
                sb.setLength(sb.length() - digits(num[i]));
                stack.pop();
            } else return;
        }
    }
    
    private int digits(int num) {
        int count = 0;
        while (num != 0) {
            num /= 10;
            count++;
        }
        return count;
    }
}