public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num.length < 4) return res;
        Arrays.sort(num);
        Map<Integer, List<int[]>> map = new HashMap<Integer, List<int[]>>();
        List<Integer> index = new ArrayList<Integer>();
        for (int i = 0; i < num.length - 1; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int sum = num[i] + num[j];
                if (!map.containsKey(sum)) {
                    map.put(sum, new ArrayList<int[]>());
                    index.add(sum);
                }
                map.get(sum).add(new int[]{i, j});
            }
        }
        Set<String> set = new HashSet<String>();
        StringBuffer sb = new StringBuffer();
        for (Integer i : index) {
            int remain = target - i;
            if (map.containsKey(remain)) {
                List<int[]> left = map.get(i);
                List<int[]> right = map.get(remain);
                for (int[] lp : left) {
                    for (int[] rp : right) {
                        if (lp[1] < rp[0]) {
                            sb.setLength(0);
                            String s = sb.append(num[lp[0]])
                                        .append(num[lp[1]])
                                        .append(num[rp[0]])
                                        .append(num[rp[1]]).toString();
                            if (set.contains(s)) continue;
                            res.add(Arrays.asList(num[lp[0]],num[lp[1]],num[rp[0]],num[rp[1]]));
                            set.add(s);
                        }
                    }
                }
            }
        }
        return res;
    }
}