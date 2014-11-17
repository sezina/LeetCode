/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
// first use a map to sort intervals by start
// linear retrieve the map and merge intervals
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 2) return intervals;
        Map<Integer, List<Interval>> map = new HashMap<Integer, List<Interval>>();
        int[] arr = new int[intervals.size()];
        int count = 0;
        for (Interval v : intervals) {
            arr[count++] = v.start;
            if (!map.containsKey(v.start)) map.put(v.start, new ArrayList<Interval>());
            map.get(v.start).add(v);
        }
        Arrays.sort(arr);
        
        List<Interval> res = new ArrayList<Interval>();
        Interval preIn = map.get(arr[0]).get(0);
        for (int i = 0; i < intervals.size(); i++) {
            for (Interval v : map.get(arr[i])) {
                if (preIn.end < v.start) {
                    res.add(preIn);
                    preIn = v;
                } else {
                    preIn.start = Math.min(preIn.start, v.start);
                    preIn.end = Math.max(preIn.end, v.end);
                }
            }
        }
        res.add(preIn);
        return res;
    }
}