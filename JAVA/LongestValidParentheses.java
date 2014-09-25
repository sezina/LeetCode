public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) return 0;
        int maxLen = 0, n = s.length();
        int[] curLen = new int[n];
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '(' && s.charAt(i + 1) == ')') {
                curLen[i] = curLen[i+1] = 2;
                maxLen = Math.max(maxLen, 2);
                int low = i - 1, high = i + 2;
                while (low >= 0 && high < n && s.charAt(low) == '(' && s.charAt(high) == ')') {
                    curLen[high] = curLen[low] = curLen[low + 1] + 2;
                    maxLen = Math.max(curLen[high], maxLen);
                    low--;
                    high++;
                }
                
                while (low > 0 && curLen[low] != 0) {
                    curLen[high - 1] += curLen[low];
                    curLen[low - curLen[low] + 1] += curLen[low + 1];
                    low = low - curLen[low];
                    maxLen = Math.max(maxLen, curLen[high - 1]);
                    
                    while (low >= 0 && high < n && s.charAt(low) == '(' && s.charAt(high) == ')') {
                        curLen[high] = curLen[low] = curLen[low + 1] + 2;
                        maxLen = Math.max(maxLen, curLen[high]);
                        low--;
                        high++;
                    }
                }
                
            }
        }
        return maxLen;
    }
}

// dp solution
public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) return 0;
        int maxLen = 0;
        Stack<Integer> stack = new Stack<Integer>(); // store indices of '('
        int[] res = new int[s.length()]; // store the cur longest parentheses len
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) continue;
                else if (stack.peek() > 0)
                    res[i] = 2 + res[stack.pop() - 1] + res[i-1]; // connect two valid seq, or increase cur len of valid seq
                else {
                    res[i] = 2 + res[i - 1]; // handle the special case that the leftmost char is '('
                    stack.pop();
                }
            }
            maxLen = Math.max(res[i], maxLen);
        }
        return maxLen;
    }
}