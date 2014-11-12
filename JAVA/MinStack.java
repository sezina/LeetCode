// using one stack, store the gap
class MinStack {
    
    long min;
    Stack<Long> stack;
    
    public MinStack() {
        stack = new Stack<Long>();
    }
    
    public void push(int x) {
        if (stack.isEmpty()) {
            min = x;
            stack.push(0l);
            return;
        }
        stack.push(x - min);
        if (x < min) min = x;
    }

    public void pop() {
        if (stack.isEmpty()) return;
        long top = stack.pop();
        if (top < 0) min = min - top;
    }

    public int top() {
        long top = stack.peek();
        if (top > 0) return (int)(top + min);
        else return (int)min;
    }

    public int getMin() {
        return (int)min;
    }
}

// using extra stack to track the min value
class MinStack {
    
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek())
            minStack.push(x);
    }

    public void pop() {
        if (stack.isEmpty()) return;
        int top = stack.pop();
        if (top == minStack.peek()) minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}