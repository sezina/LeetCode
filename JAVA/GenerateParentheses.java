// naive method
public class Solution {
    private static final String UNIT = "()";
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if (n == 0) return result;
        Set<String> showBefore = new HashSet<String>();
        Queue<String> queue = new ArrayDeque<String>();
        queue.add(UNIT);
        showBefore.add(UNIT);
        while (!queue.isEmpty()) {
            String s = queue.poll();
            if (s.length() == n * 2)
                result.add(s);
            else {
                for (int i = 0; i <= s.length() / 2; i++) {
                    String news = s.substring(0, i) + UNIT + s.substring(i, s.length());
                    if (!showBefore.contains(news)) {
                        showBefore.add(news);
                        queue.add(news);
                    }
                }
            }
        }
        return result;
    }
}