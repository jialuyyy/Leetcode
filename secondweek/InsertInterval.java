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


class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        int[][] newIntervals = new int[intervals.length + 1][];
        
        for (int i = 0; i < intervals.length; i++) {
            newIntervals[i] = intervals[i];
        }
        newIntervals[intervals.length] = newInterval;
        
        //sort the list by ascending order of the left elememt
        Arrays.sort(newIntervals, new Comparator<int[]>(){
            public int compare(int[] i1, int[] i2) {
                return i1[0] - i2[0];
            }
        });
        
        List<int[]> ret = new ArrayList<>();
        ret.add(newIntervals[0]);
        
        for (int i = 1; i < newIntervals.length; i++) {
            int[] prev = ret.get(ret.size() - 1);
            int[] cur = newIntervals[i];
            
            if (prev[1] >= cur[0]) {
                prev[1] = Math.max(cur[1], prev[1]);
            } else {
                ret.add(cur);
            }
        }
        
        return ret.toArray(new int[ret.size()][]);
    }
}
