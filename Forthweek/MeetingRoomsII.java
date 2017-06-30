/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

//1.sort the intervals based on the starting time
//2. use a heap to keep track the current minimum ending time of the meeting and iterate over the sorted intervals array to update the priority queue
// if current intervals starting time is less than the ending time of current head element, which mean we need one more meeting room
//so push the interval into the queue; else, update the ending time of the head element to be current element's ending time and push it 
//into the queue

//Time Compexity: O(nlog(n)) -> sorting
//O(nlog(n)) -> queue
// O(nlog(n))
//beats 59.90%

public class MeetingRoomsII {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        
        //track the minimum of the ending time of the meeting
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {
                return i1.end - i2.end;
            }
        });
        
        pq.offer(intervals[0]);
        
        for (int i = 1; i < intervals.length; i++) {
            Interval cur = pq.poll();
            
            if (cur.end > intervals[i].start) {
                pq.offer(intervals[i]);
            } else {
                //the end may be changed, so the interval should be polled first and then pushed back
                cur.end = intervals[i].end;
            }
            
            pq.offer(cur);
            
        }
        
        return pq.size();
    }
}


//version 2, sweeping line solution
//split intervals into two Pair, one is starting pair and the other one is ending pair
//sort the pair based on the timestamp, if two timestamps are equal, put the ending one first
//iterate over the whole pair list, if meeting start, count++; else, count--, use a ret variable to maintain the maximum result in the 
//whole process and return it.
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
    class Pair {
        int timeStamp;
        int isStart;
        
        public Pair(int timeStamp, int isStart) {
            this.timeStamp = timeStamp;
            this.isStart = isStart;
        }
    }
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        
        List<Pair> list = new ArrayList<Pair>();
        for (Interval interval: intervals) {
            list.add(new Pair(interval.start, 1));
            list.add(new Pair(interval.end, 0));
        }
        
        Collections.sort(list, new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2) {
                if (p1.timeStamp == p2.timeStamp) {
                    //end is 0 and start is 1, so end will be in the front of start
                    return p1.isStart - p2.isStart;
                }
                return p1.timeStamp - p2.timeStamp;
            }
        });
        
        int minMeetingRoom = 0;
        int count = 0;
        for (Pair pair: list) {
            if (pair.isStart == 1) {
                count++;
            } else {
                count--;
            }
            
            minMeetingRoom = Math.max(minMeetingRoom, count);
        }
        
        return minMeetingRoom;
    }
}
