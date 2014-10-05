// the thought is same as largest rectangle
// O(n^2) time
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int area = 0, rs = matrix.length, cs = matrix[0].length, maxArea = 0;
        int[][] bars = new int[rs][cs];
        
        for (int i = 0; i < cs; i++) bars[0][i] = matrix[0][i] - '0';
        for (int i = 1; i < rs; i++)
            for (int j = 0; j < cs; j++)
                if (matrix[i][j] == '1') bars[i][j] = bars[i-1][j] + 1;

        for (int i = 0; i < rs; i++) {
            Stack<Integer> s = new Stack<Integer>();
            s.add(-1);
            for (int j = 0; j < cs; j++) {
                while (s.peek() != -1 && bars[i][s.peek()] > bars[i][j]) {
                    int tp = s.pop();
                    maxArea = Math.max(maxArea, bars[i][tp] * (j-s.peek()-1));
                }
                s.add(j);
            }
            
            while (s.peek() != -1) {
                int tp = s.pop();
                maxArea = Math.max(maxArea, bars[i][tp]*(bars[i].length-s.peek()-1));
            }
        }
        return maxArea;
    }
}