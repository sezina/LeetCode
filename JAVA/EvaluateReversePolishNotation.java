// using a stack
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (String token : tokens) {
            if (token.charAt(0) >= '0' && token.charAt(0) <= '9' || token.length() != 1)
                stack.push(Integer.parseInt(token));
            else {
                int operandB = stack.pop();
                int operandA = stack.pop();
                if (token.equals("+"))
                    stack.push(operandA + operandB);
                else if (token.equals("-"))
                    stack.push(operandA - operandB);
                else if (token.equals("*"))
                    stack.push(operandA * operandB);
                else
                    stack.push(operandA / operandB);
            }
        }
        if (stack.isEmpty()) return 0;
        return stack.pop();
    }
}