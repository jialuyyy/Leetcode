//beats 65.61%
//one pass iterate over the whole array list
//Time Complexity: O(n)
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ret = new ArrayList<Interval>();
        if (newInterval == null) {
            return ret;
        }
        
        
        int i = 0;
        while (i < intervals.size() && newInterval.start > intervals.get(i).end) {
            ret.add(intervals.get(i));
            i++;
        }
        
        while (i < intervals.size() && newInterval.end >= intervals.get(i).start) {
            newInterval = new Interval(Math.min(newInterval.start, intervals.get(i).start), Math.max(newInterval.end, intervals.get(i).end));
            i++;
        }
        
        ret.add(newInterval);
        
        while (i < intervals.size()) {
            ret.add(intervals.get(i));
            i++;
        }
        
        return ret;
    }
}
