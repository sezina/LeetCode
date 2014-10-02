// 1. change 3sum to 2sum.
// 2. reference: https://en.wikipedia.org/wiki/3SUM
// 3. O(n^2) time 
public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num.length < 3) return res;
        Arrays.sort(num);
        int n = num.length;
        Set<String> set = new HashSet<String>();
        for (int i = n - 1; i >= 0 && num[i] >= 0; i--) {
            Map<Integer, Integer> map = sumHelper(num, -num[i], i);
            if (map.isEmpty()) continue;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                String s = new StringBuffer()
                                .append(num[entry.getKey()])
                                .append(num[entry.getValue()]).toString();
                if (set.contains(s)) continue;
                res.add(Arrays.asList(num[entry.getKey()], num[entry.getValue()], num[i]));
                set.add(s);
            }
        }
        return res;
    }
    
    private Map<Integer, Integer> sumHelper(int[] num, int target, int index) {
        Map<Integer, Integer> ans = new HashMap<Integer, Integer>();
        int i = 0, j = index - 1;
        while (i < j) {
            int temp = num[i] + num[j];
            if (temp == target) {
                ans.put(i, j);
                i++;
                j--;
            } else if (temp < target) {
                i++;
            } else j--;
        }
        return ans;
    }
}

// neat code
public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num.length < 3) return res;
        Arrays.sort(num);
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < num.length; i++)
            indexMap.put(num[i], i);
        
        for (int i = 0; i < num.length; i++) {
            if (i > 0 && num[i] == num[i - 1]) continue;
            for (int j = i + 1; j < num.length; j++) {
                if (j > i + 1 && num[j] == num[j - 1]) continue;
                if (indexMap.containsKey(-num[i]-num[j]) && indexMap.get(-num[i]-num[j]) > j)
                    res.add(Arrays.asList(num[i], num[j], -num[i]-num[j]));
            }
        }
        return res;
    }
}