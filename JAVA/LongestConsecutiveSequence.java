public class Solution {
    public int longestConsecutive(int[] num) {
        if (num.length == 0) return 0;
        if (num.length == 1) return 1;
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        for (int i = 0; i < num.length; i++)
            countMap.put(num[i], 1);
        int maxLen = 0;
        for (int i = 0; i < num.length; i++) {
            if (visited.contains(num[i])) continue;
            int len = 0;
            while (countMap.containsKey(len + num[i])) {
                visited.add(len + num[i]);
                countMap.put(num[i], len + countMap.get(len + num[i]));
                len = countMap.get(num[i]);
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}

// one pass loop
public class Solution {
    public int longestConsecutive(int[] num) {
        if (num.length == 0) return 0;
        if (num.length == 1) return 1;
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        int maxLen = 0;
        for (int i = 0; i < num.length; i++) {
            if (countMap.containsKey(num[i])) continue;
            int low = num[i], up = num[i];
            if (countMap.containsKey(num[i] - 1))
                low = countMap.get(num[i] - 1);
            if (countMap.containsKey(num[i] + 1))
                up = countMap.get(num[i] + 1);
            
            maxLen = Math.max(maxLen, up - low + 1);
            countMap.put(num[i], num[i]);
            countMap.put(low, up);
            countMap.put(up, low);
        }
        return maxLen;
    }
}