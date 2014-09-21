// straightforward solution
public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> res = new ArrayList<String>();
        if (strs.length < 2) return res;
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String sig = new String(cs);
            
            if (!map.containsKey(sig)) {
                map.put(sig, new ArrayList<String>());
            }
            map.get(sig).add(s);
        }
        
        for (Map.Entry<String, List<String>> entry : map.entrySet())
            if (entry.getValue().size() > 1)
                res.addAll(entry.getValue());
        return res;
    }
}