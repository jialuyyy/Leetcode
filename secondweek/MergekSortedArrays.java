//Time complexity : O(nklog(n)), n is the length of the arrays and the k is the average length of each one dimentional array
public class MergekSortedArrays {
    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
    private class Point {
        int value;
        int index_x;
        int index_y;
        
        public Point(int value, int index_x, int index_y) {
            this.value = value;
            this.index_x = index_x;
            this.index_y = index_y;
        }
    }
    public List<Integer> mergekSortedArrays(int[][] arrays) {
        // Write your code here
        List<Integer> ret = new ArrayList<Integer>();
        
        if (arrays == null || arrays.length == 0) {
            return ret;
        }
        
        PriorityQueue<Point> pq = new PriorityQueue<Point>(arrays.length, new Comparator<Point>() {
            public int compare(Point p1, Point p2) {
                return p1.value - p2.value;
            }
        });
        
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0)
                pq.offer(new Point(arrays[i][0], i, 0));
        }
        
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            ret.add(p.value);
            
            int index1 = p.index_x;
            int index2 = p.index_y;
            
            if (index2 + 1 < arrays[index1].length) {
                pq.offer(new Point(arrays[index1][index2 + 1], index1, index2 + 1));
            }
            
        }
        
        return ret;
    }
}
