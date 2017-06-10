//sort by starting point
//add the first interval into the ret list, iterate from the second interval to the end
//if the cur.end > start, create a new Interval and add it into the list
//else, if the cur.end > end, update the end value of the interval in the ret list

//Time complexity: sort -> O(nlog) + iterate O(n) 
//Overall O(nlogn)

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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ret = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            return ret;
        }
        //sort by starting point
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
            
            if (end < cur.start) {
                Interval interval = new Interval(cur.start, cur.end);
                ret.add(interval);
                
                start = cur.start;
                end = cur.end;
            } else if  (cur.end > end) {
                
                ret.get(ret.size() - 1).end = cur.end;
                end = cur.end;
            }
        }
        return ret;
    }
}
