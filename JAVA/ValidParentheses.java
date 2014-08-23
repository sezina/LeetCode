public class Solution {
    public boolean isValid(String s) {
        if (s.isEmpty()) return true;
        Stack<Character> pStack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char p = s.charAt(i);
            if (p == '(' || p == '{' || p =='[')
                pStack.push(p);
            else {
                if (pStack.isEmpty()) return false;
                if (p == ')' && pStack.peek() == '(') pStack.pop();
                else if (p == ']' && pStack.peek() == '[') pStack.pop();
                else if (p == '}' && pStack.peek() == '{') pStack.pop();
                else return false;
            }
        }
        if (pStack.isEmpty()) return true;
        return false;
    }
}