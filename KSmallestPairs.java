class KSmallestPairs {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return ret;
        //int[3] => (1, 2, 0)
        Queue<int[]> pq = new PriorityQueue<>(k, new Comparator<int[]>(){
            public int compare(int[] p1, int[] p2) {
                return p1[0] + p1[1] - p2[0] - p2[1];
            }
        });
        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }
        
        while (k > 0 && !pq.isEmpty()) {
            int[] cur = pq.poll();
            k--;
            List<Integer> list = new ArrayList<>();
            list.add(cur[0]);
            list.add(cur[1]);
            
            ret.add(list);
            
            if (cur[2] >= nums2.length - 1)
                continue;
            //offer the candidate into the pq
            pq.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }
        
        return ret;
        
    }
}
