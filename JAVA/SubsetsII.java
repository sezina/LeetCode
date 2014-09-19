public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> ans = new ArrayList<Integer>();
        Set<String> exist = new HashSet<String>();
        exist.add("");
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(0,"");
        res.add(ans);
        for (int i = 0; i < num.length; i++) {
            int n = res.size();
            for (int j = 0; j < n; j++) {
                ans = new ArrayList<Integer>(res.get(j));
                String tempsum = map.get(j) + num[i];
                if (!exist.contains(tempsum)) {
                    exist.add(tempsum);
                    map.put(res.size(), tempsum);
                    ans.add(num[i]);
                    res.add(ans);
                }
            }
        }
        return res;
    }
}