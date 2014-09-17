public class Solution {
    List<String> res;
    int size;
    public List<String> wordBreak(String s, Set<String> dict) {
        res = new ArrayList<String>();
        if (s.isEmpty() || dict.isEmpty()) return res;
        boolean solved = false;
        size = s.length();
        Map<Integer, List<String>> graph = new HashMap<Integer, List<String>>();
        Queue<Integer> queue = new ArrayDeque<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        queue.add(0);
        set.add(0);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            for (int i = index + 1; i <= s.length(); i++) {
                String sub = s.substring(index, i);
                if (dict.contains(sub)) {
                    if (i == s.length()) solved = true;
                    if (!set.contains(i)) {
                        queue.add(i);
                        set.add(i);
                    }
                    if (!graph.containsKey(index)) graph.put(index, new ArrayList<String>());
                    graph.get(index).add(sub);
                }
            }
        }
        if (!solved) return res;
        List<String> oneRes = new ArrayList<String>();
        int len = 0;
        helper(graph, oneRes, len, 0);
        return res;
    }
    
    private void helper(Map<Integer, List<String>> graph, List<String> oneRes, int len, int index) {
        if (len > size) return;
        if (len == size) {
            StringBuffer sb = new StringBuffer();
            for (String s : oneRes)
                sb.append(s).append(' ');
            sb.setLength(sb.length() - 1);
            res.add(sb.toString());
            return;
        }
        if (!graph.containsKey(index)) return;
        for (int i = 0; i < graph.get(index).size(); i++) {
            String temp = graph.get(index).get(i);
            oneRes.add(temp);
            helper(graph, oneRes, len + temp.length(), index + temp.length());
            oneRes.remove(oneRes.size() - 1);
        }
    }
}