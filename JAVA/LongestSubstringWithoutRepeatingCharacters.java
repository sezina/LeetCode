// straight forward solution
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