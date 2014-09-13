// straight forward solution
// can not handle unicode character
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int max = 1;
        Set<Character> set = new HashSet<Character>();
        Queue<Character> queue = new ArrayDeque<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                while (!queue.isEmpty() && queue.poll() != c);
                set.clear();
                set.addAll(queue);
            }
            queue.add(c);
            set.add(c);
            if (max < queue.size()) max = queue.size();
        }
        return max;
    }
}

// O(n) solution
// handle unicode
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        Map<Integer, Integer> dic = new HashMap<Integer, Integer>();
        int max = 0, length = 0;
        for (int i = 0; i < s.length(); i++) {
            length++;
            //if found repeating char, check if the char is in the current substring
            if (dic.containsKey(s.codePointAt(i)) && length > (i - dic.get(s.codePointAt(i))))
                length = i - dic.get(s.codePointAt(i));
            // get the longest substring
            max = Math.max(length, max);
            dic.put(s.codePointAt(i), i);
        }
        return max;
    }
}