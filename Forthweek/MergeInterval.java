//beats 53.64%
//Collections.sort to sort the intervals based on the starting point value
//iterate over the intervals list and update the result array list
//two conditions:
//[1,2][3,4] 
//if (cur.start > end) add the interval into the result list and update the start and end value to do the next comparison
//[1,5][2,6]
//else if (cur.end > end), update the end value of the previous interval and update the end
//[1,5][2,3]
//else means the current interval is included in the previous one, so do nothing

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class MergeInterval {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ret = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            return ret;
        }
        
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        
        ret.add(intervals.get(0));
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (cur.start > end) {
                ret.add(cur);
                start = cur.start;
                end = cur.end;
            } else if (cur.end > end){
                ret.get(ret.size() - 1).end = cur.end;
                end = cur.end;
            }
        }
        
        return ret;
    }
}
