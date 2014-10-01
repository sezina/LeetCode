// dynamic programming and bfs
public class Solution {
    public int minCut(String s) {
        if (s.length() < 2) return 0;
        
        int len = s.length();
        boolean[][] isPalin = new boolean[len][len];
        for (int i = 0; i < len; i++)
            isPalin[i][i] = true;
        for (int j = 0; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (j == i + 1) isPalin[i][j] = (s.charAt(i) == s.charAt(j));
                else isPalin[i][j] = (s.charAt(i) == s.charAt(j) && isPalin[i + 1][j - 1]);
            }
        }
        if (isPalin[0][len - 1]) return 0;
        
        return helper(s, isPalin);
    }
    
    private int helper(String s, boolean[][] isPalin) {
        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.add(0);
        Map<Integer, Integer> cutMap = new HashMap<Integer, Integer>();
        cutMap.put(0, 0);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            for (int i = s.length(); i > index; i--) {
                if (isPalin[index][i - 1]) {
                    if (i == s.length()) return cutMap.get(index);
                    else {
                        if (!cutMap.containsKey(i)) {
                            cutMap.put(i, cutMap.get(index) + 1);
                            queue.add(i);
                        }
                        else
                            cutMap.put(i, Math.min(cutMap.get(i), cutMap.get(index) + 1));
                    }
                }
            }
        }
        return s.length() - 1;
    }
}

// dynamic programming
public class Solution {
    public int minCut(String s) {
        if (s.length() < 2) return 0;
        
        int len = s.length();
        boolean[][] isPalin = new boolean[len][len];
        int[] cuts = new int[len];
        
        for (int i = len - 1; i >= 0; i--) {
            cuts[i] = len - i - 1;
            for (int j = i; j < len; j++) {
                if (j - i < 2) isPalin[i][j] = (s.charAt(i) == s.charAt(j));
                else isPalin[i][j] = (s.charAt(i) == s.charAt(j) && isPalin[i + 1][j - 1]);
                
                if (isPalin[i][j]) {
                    if (j == len - 1) cuts[i] = 0;
                    else cuts[i] = Math.min(cuts[i], cuts[j + 1] + 1);
                }
            }
        }
        
        return cuts[0];
    }
}