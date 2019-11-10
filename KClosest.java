class KClosest {
    public int[][] kClosest(int[][] points, int K) {
        Queue<int[]> pq = new PriorityQueue<>((n1, n2) -> dist(n2) - dist(n1));
        //nlogk
        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > K)
                pq.poll();
        }
        
        int[][] ret = new int[K][2];
        int index = 0;
        //klogk
        while(!pq.isEmpty()) {
            ret[index] = pq.poll();
            index++;
        }
        
        return ret;
    }
    
    private int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
