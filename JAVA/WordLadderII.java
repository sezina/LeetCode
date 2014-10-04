public class Solution {
    List<List<String>> res;
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        res = new ArrayList<List<String>>();
        Map<String, Integer> steps = new HashMap<String, Integer>();
        Map<String, List<String>> graph = new HashMap<String, List<String>>();
        dict.add(end);
        for (String s : dict) {
            steps.put(s, Integer.MAX_VALUE);
            graph.put(s, new ArrayList<String>());
        }
        steps.put(start, 0);
        
        Queue<String> queue = new ArrayDeque<String>();
        queue.add(start);
        
        int minStep = Integer.MAX_VALUE;
        
        while (!queue.isEmpty()) {
            String w = queue.poll();
            
            int step = steps.get(w) + 1;
            if (step > minStep) break;
            
            StringBuffer sb = new StringBuffer(w);
            for (int i = 0; i < w.length(); i++) {
                char oldc = sb.charAt(i);
                for (char c = 'a'; c < 'z'; c++) {
                    sb.setCharAt(i, c);
                    String neww = sb.toString();
                    if (steps.containsKey(neww)) {
                        if (step > steps.get(neww)) continue;
                        else if (step < steps.get(neww)) {
                            queue.add(neww);
                            steps.put(neww, step);
                        }
                        graph.get(neww).add(w);
                        if (neww.equals(end)) minStep = step;
                    }
                }
                sb.setCharAt(i, oldc);
            }
        }
        
        List<String> laddar = new ArrayList<String>();
        laddar.add(end);
        helper(graph, end, start, laddar);
        return res;
    }
    
    private void helper(Map<String, List<String>> parents, String next, String start, List<String> laddars) {
        if (next.equals(start)) {
            res.add(new ArrayList<String>(laddars));
            return;
        }
        if (parents.get(next).isEmpty()) return;
        
        for (int i = 0; i < parents.get(next).size(); i++) {
            laddars.add(0, parents.get(next).get(i));
            helper(parents, parents.get(next).get(i), start, laddars);
            laddars.remove(0);
        }
    }
}