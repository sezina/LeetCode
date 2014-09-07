// naive solution
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty() || triangle.get(0).isEmpty()) return 0;
        int th = triangle.size();
        int[] results = new int[triangle.get(th - 1).size()];
        results[0] = triangle.get(0).get(0);
        for (int i = 1; i < th; i++) {
            results[i] = triangle.get(i).get(i) + results[i - 1];
            for (int j = i - 1; j > 0; j--) {
                results[j] = Math.min(results[j] + triangle.get(i).get(j),
                                    results[j - 1] + triangle.get(i).get(j));
            }
            results[0] += triangle.get(i).get(0);
        }
        int min = results[0];
        for (int i = 1; i < results.length; i++)
            if (results[i] < min) min = results[i];
        return min;
    }
}