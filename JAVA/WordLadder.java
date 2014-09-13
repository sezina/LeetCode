// BFS
public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start.length() == 1) return 2;
        else if (dict.isEmpty()) return 0;
        
        Map<String, Integer> lens = new HashMap<String, Integer>();
        Queue<String> queue = new ArrayDeque<String>();
        queue.add(start);
        lens.put(start, 2);
        
        while (!queue.isEmpty()) {
            String temp = queue.poll();
            int size = temp.length();
            int len = lens.get(temp);
            for (int i = 0; i < size; i++) {
                for (char j = 'a'; j <= 'z'; j++) {
                    String ns = temp.substring(0, i) + j + temp.substring(i + 1, size);
                    if (ns.equals(end)) return len;
                    if (lens.containsKey(ns)) continue;
                    if (dict.contains(ns)) {
                        queue.add(ns);
                        lens.put(ns, len + 1);
                    }
                }
            }
        }
        return 0;
    }
}