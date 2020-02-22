class ShipWithinDays {
    //[1,2,3,4,5,6,7,8,9,10], D = 5
    //binary search by days
    //the minimum day = 1
    //the maximum day = 10
    //the minimum ship capacity = 10
    //the maximum ship capacity = 55
    public int shipWithinDays(int[] weights, int D) {
        if (weights == null || weights.length == 0)
            return 0;
        
        int left = weights[0];
        int right = 0;
        for (int w : weights) {
            left = Math.max(w, left);
            right += w;
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            int need = 1;
            int cur = 0;
            
            for (int w : weights) {
                if (cur + w > mid) {
                    need += 1;
                    cur = 0;
                }
                cur += w;
            }
            
            if (need > D)
                left = mid + 1;
            else 
                right = mid;
        }
        
        return left;
    }
}
