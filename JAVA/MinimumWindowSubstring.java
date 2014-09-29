// O(n)
public class Solution {
    public String minWindow(String S, String T) {
        if (S == null || T == null || S.isEmpty() || T.isEmpty() || S.length() < T.length()) return "";
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int count = T.length(), start = 0, lindex = 0, rindex = S.length();
        String res = S;
        boolean isSolve = false;
        for (int i = 0; i < T.length(); i++) {
            if (!map.containsKey(T.charAt(i)))
                map.put(T.charAt(i), 0);
            map.put(T.charAt(i), map.get(T.charAt(i)) - 1);
        }
        
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
            
            if (T.indexOf(c) > -1 && map.get(c) <= 0) count--;
            if (count > 0) continue;
            isSolve = true;
            while (map.get(S.charAt(start)) > 0) {
                map.put(S.charAt(start), map.get(S.charAt(start)) - 1);
                start++;
            }
            map.put(S.charAt(start), -1);
            lindex = start;
            rindex = i + 1;
            if (rindex - lindex < res.length())
                res = S.substring(lindex, rindex);
            start++;
            if (i != S.length() - 1)
                count++;
        }
        if (count > 0 && !isSolve) return "";
        
        return res;
    }
}