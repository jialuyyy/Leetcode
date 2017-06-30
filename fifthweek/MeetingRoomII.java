//create a wrapper calss to represent the each pair of the intervals, for each pair, one instance is the timestamp and the other one denotes
//if it is the end or the start
//use a comparator to sort the list of pairs, if the timestamps are the same, put the ending in front of the start
//iterate over the sorted list, and if the point is start, count++, else count--, keep a variable to denote the maximum number of the meeting
//rooms
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class MeetingRoomII {
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
