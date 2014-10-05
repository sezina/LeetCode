// O(n) time
// reference: http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
public class Solution {
    public int largestRectangleArea(int[] height) {
        int maxArea = 0, left = 0, right = height.length - 1;
        if (height.length == 0) return 0;
        if (height.length == 1) return height[0];
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(-1);
        
        for (int i = 0; i < height.length; i++) {
            while (stack.peek() != -1 && height[stack.peek()] > height[i]) {
                int tp = stack.pop();
                maxArea = Math.max(maxArea, height[tp]*(i-1-stack.peek()));
            }
            stack.push(i);
        }
        
        while (stack.peek() != -1) {
            int tp = stack.pop();
            maxArea = Math.max(maxArea, height[tp]*(height.length-1-stack.peek()));
        }
        
        return maxArea;
    }
}

// O(nlogn) Solution, use segment tree
// reference: http://www.geeksforgeeks.org/largest-rectangular-area-in-a-histogram-set-1/