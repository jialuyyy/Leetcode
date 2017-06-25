//O(klog(k))
//thoughts: put k elements into the queue first and then poll the element from the queue in the meantime push next possible value into
//the queue.

public class FindKSmallestPairs {
    private int[] dx = {0, 1};
    private int[] dy = {1, 0};
    class Pair {
        int index1;
        int index2;
        int sum;
        public Pair(int index1, int index2, int sum) {
            this.index1 = index1;
            this.index2 = index2;
            this.sum = sum;
        }
    }
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> ret = new ArrayList<int[]>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return ret;
        PriorityQueue<Pair> q = new PriorityQueue<Pair>(k, new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2) {
                return p1.sum - p2.sum;
            }
        });
        
        for (int i = 0; i < k && i < nums1.length; i++) {
            Pair p = new Pair(i, 0, nums1[i] + nums2[0]);
            q.offer(p);
        }
        
        while (ret.size() < k && !q.isEmpty()) {
            Pair cur = q.poll();
            ret.add(new int[]{nums1[cur.index1], nums2[cur.index2]});
            int index1 = cur.index1;
            int index2 = cur.index2 + 1;
            
            if (index2 < nums2.length) {
                Pair p = new Pair(index1, index2, nums1[index1] + nums2[index2]);
                q.offer(p);
            }
            
        }
        
        
        return ret;
        
    }
}
