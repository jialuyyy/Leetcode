class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        //small priority queue
        Queue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2) {
                return i1 - i2;
            }
        });
        
        //nlog(k)
        //if using large priority queue, time complexity should be nlog(n)
        for (int i = 0; i < nums.length; i++) {
            if (pq.size() < k) {
                pq.offer(nums[i]);
            } else {
                if (pq.peek() < nums[i]) {
                    pq.poll();
                    pq.offer(nums[i]);
                }
            }
        }
        
        return pq.poll();
    }
}
