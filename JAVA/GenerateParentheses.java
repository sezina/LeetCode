// naive method
// Catalan number: https://en.wikipedia.org/wiki/Catalan_number
// Dyck Word: https://en.wikipedia.org/wiki/Dyck_language
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


public class Solution {
    public List<String> generateParenthesis(int n) {
        char[] arr = new char[n*2];
        List<String> result = new ArrayList<String>();
        genHelper(result,arr,n,n,0);
        return result;
    }
    
    private void genHelper(List<String> res, char[] arr, int left, int right, int index) {
        if (left == 0 && right == 0) {
            res.add(String.copyValueOf(arr));
            return;
        }
        
        if (left > 0) {
            arr[index] = '(';
            genHelper(res, arr, left - 1, right, index + 1);
        }
        if (right > left) {
            arr[index] = ')';
            genHelper(res, arr, left, right - 1, index + 1);
        }
    }
}