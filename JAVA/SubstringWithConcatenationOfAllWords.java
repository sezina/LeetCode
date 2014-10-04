// thought same as minimum window string
public class Solution {
    List<Integer> res;
    public List<Integer> findSubstring(String S, String[] L) {
        res = new ArrayList<Integer>();
        if (S == null || S.isEmpty() || L.length ==0) return res;
        int len = L[0].length();
        int limit = len * L.length;
        if (S.length() < limit) return res;
        
        Map<String, Integer> countL = new HashMap<String, Integer>();
        Map<String, Integer> countS = new HashMap<String, Integer>();
        
        for (int i = 0; i < L.length; i++){
            if (countL.containsKey(L[i]))
                countL.put(L[i], countL.get(L[i]) + 1);
            else countL.put(L[i], 1);
        }
        
        for (int i = S.length(); i >= limit; i--) {
            int start = i - len;
            String w = S.substring(start, start + len);
            while (countL.containsKey(w) && countL.get(w) > 0) {
                countL.put(w, countL.get(w) - 1);
                if (countS.containsKey(w))
                    countS.put(w, countS.get(w) + 1);
                else countS.put(w, 1);
                if (i - start == limit) {
                    res.add(0, start);
                    break;
                }
                
                start -= len;
                if (start >= 0)
                    w = S.substring(start, start + len);
            }
            
            for (String s : countS.keySet()) {
                countL.put(s, countL.get(s) + countS.get(s));
            }
            countS.clear();
        }
        
        return res;
    }
}

// an elegant code use hashcode of strings
public class Solution {
    List<Integer> res;
    public List<Integer> findSubstring(String S, String[] L) {
        res = new ArrayList<Integer>();
        if (S == null || S.isEmpty() || L.length ==0) return res;
        int len = L[0].length();
        int limit = len * L.length;
        if (S.length() < limit) return res;
        
        Set<String> set = new HashSet<String>();
        long hashSum = 0;
        for (int i = 0; i < L.length; i++) {
            hashSum += L[i].hashCode();
            set.add(L[i]);
        }
        
        for (int i = 0; i <= S.length() - limit; i++) {
            long tempHash = 0;
            boolean reachEnd = true;
            for (int j = 0; j < L.length; j++) {
                String w = S.substring(i + j * len, i + (j+1)*len);
                if (!set.contains(w)) {
                    reachEnd = false;
                    break;
                }
                tempHash += w.hashCode();
            }
            if (reachEnd && tempHash == hashSum) res.add(i);
        }
        
        return res;
    }
}