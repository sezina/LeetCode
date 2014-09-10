/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null) return intervals;
        List<Interval> res = new ArrayList<Interval>();
        if (intervals.isEmpty() || newInterval.start > intervals.get(intervals.size() - 1).end) {
            res.addAll(intervals);
            res.add(newInterval);
            return res;
        }
        if (newInterval.end < intervals.get(0).start) {
            res.add(newInterval);
            res.addAll(intervals);
            return res;
        }
        int starti = -1, endi = -1, i = 0, news = newInterval.start, newe = newInterval.end, s,e;
        for (; i < intervals.size(); i++) {
            s = intervals.get(i).start;
            e = intervals.get(i).end;
            if (s <= newInterval.start && newInterval.start <= e) {
                starti = i;
                news = s;
                break;
            } else if (s > newInterval.start) {
                starti = i;
                news = newInterval.start;
                break;
            }
        }
        i = i > 0 ? i - 1 : 0;
        for (; i < intervals.size(); i++) {
            s = intervals.get(i).start;
            e = intervals.get(i).end;
            if (s <= newInterval.end && newInterval.end <= e) {
                endi = i + 1;
                newe = e;
                break;
            } else if (e > newInterval.end) {
                endi = i;
                newe = newInterval.end;
                break;
            }
        }
        if (endi == -1) endi = intervals.size();
        res.addAll(intervals.subList(0, starti));
        res.add(new Interval(news, newe));
        res.addAll(intervals.subList(endi, intervals.size()));
        return res;
    }
}