/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null) return 0;
        if (points.length < 3) return points.length;
        Map<String, Integer> map = new HashMap<String, Integer>();
        int maxCount = 0;
        
        for (int i = 0; i < points.length; i++) {
            map.clear();
            int dup = 0, max = 0;
            for (int j = i + 1; j < points.length; j++) {
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                if (x == 0 && y == 0) {
                    dup++;
                    continue;
                }
                
                int gcdVal = gcd(x, y);
                if (gcdVal != 0) {
                    x /= gcdVal;
                    y /= gcdVal;
                }
                String key = new StringBuffer().append(x).append(y).toString();
                if (map.containsKey(key))
                    map.put(key, map.get(key) + 1);
                else
                    map.put(key, 1);
                max = Math.max(max, map.get(key));
            }
            maxCount = Math.max(maxCount, max + dup + 1);
        }
        return maxCount;
    }
    
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}