//1 brute force, iterate over the whole array every time to find the interval with the minimum starting value that is greater than the 
//end value of the current interval O(n * n)

//2.use treemap to store the <starting point, index>, the map will be ordered by the starting point, it will be a balanced binary search tree
//so the search will be log(n), the time complexity will be O(nlog(n)).

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

/*
[3, 4] [2, 3] [1, 2]

(1, 2) (2, 1) (3, 0)

*/
public class FindRightInterval {
    public int[] findRightInterval(Interval[] intervals) {
        int[] ret = new int[intervals.length];
        
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
        
        //the intervals will be sorted by the starting point
        //will be a balanced binary search tree
        for (int i = 0; i < intervals.length; i++) {
            treeMap.put(intervals[i].start, i);
        }
        
        for (int i = 0; i < intervals.length; i++) {
            Integer key = treeMap.ceilingKey(intervals[i].end);
            ret[i] = key == null? -1: treeMap.get(key);
        }
        
        return ret;
    }
}
